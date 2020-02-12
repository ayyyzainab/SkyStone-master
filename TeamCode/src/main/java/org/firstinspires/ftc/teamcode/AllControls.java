package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="AllControls", group="")

public class AllControls extends OpMode
{

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
    private DcMotor pinion1 = null;
    private DcMotor pinion2 = null;
    private DcMotor clawgear = null;
    private Servo latch;
    private Servo latch2;
    private Servo claw;
    private Servo claw2                                                                                                                                           ;
    int x;

    {
        x = 0;
    }

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft  = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        pinion1 = hardwareMap.get(DcMotor.class, "pinion1");
        pinion2  = hardwareMap.get(DcMotor.class, "pinion2");
        clawgear = hardwareMap.get(DcMotor.class, "clawgear");
        latch = hardwareMap.servo.get("latch");
        latch2 = hardwareMap.servo.get("latch2");
        claw = hardwareMap.servo.get("claw");
        claw2 = hardwareMap.servo.get("claw2");

        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        pinion1.setDirection(DcMotor.Direction.FORWARD);
        pinion2.setDirection(DcMotor.Direction.REVERSE);
        clawgear.setDirection(DcMotor.Direction.FORWARD);


        //RUNNING WITHOUT ENCODERS
        pinion1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        pinion2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        clawgear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        telemetry.addData("Status", "Initialized");
    }



    @Override
    public void start() {
        runtime.reset();
    }


    @Override
    public void loop() {


        if (gamepad1.left_stick_y < -0.5 && gamepad1.left_stick_x < 0.25 && gamepad1.left_stick_x > -0.25 ) // go forwards
        {
            frontLeft.setPower(1);
            frontRight.setPower(1);
            backRight.setPower(-1);
            backLeft.setPower(-1);
        }
        if (gamepad1.left_stick_y > 0.5 && gamepad1.left_stick_x < 0.25 && gamepad1.left_stick_x > -0.25) // go backwards
        {
            frontLeft.setPower(-1);
            frontRight.setPower(-1);
            backRight.setPower(1);
            backLeft.setPower(1);


        }
        if (gamepad1.left_stick_x < -0.5 && gamepad1.left_stick_y < 0.25 && gamepad1.left_stick_y > -0.25) // go left
        {
            frontLeft.setPower(-1);
            frontRight.setPower(1);
            backRight.setPower(1);
            backLeft.setPower(-1);
        }

        if (gamepad1.left_stick_x > 0.5 && gamepad1.left_stick_y < 0.25 && gamepad1.left_stick_y > -0.25) // go right
        {
            frontLeft.setPower(1);
            frontRight.setPower(-1);
            backRight.setPower(-1);
            backLeft.setPower(1);

        }

        if (gamepad1.left_stick_x > 0.5 && gamepad1.left_stick_x < 0.9 && gamepad1.left_stick_y < -0.5 ) // right diagonal forward
        {
            frontLeft.setPower(-1);
            frontRight.setPower(0);
            backRight.setPower(1);
            backLeft.setPower(0);
        }

        if (gamepad1.left_stick_x < -0.5 && gamepad1.left_stick_x > -0.9 && gamepad1.left_stick_y < -0.5 ) //left diagonal forward
        {
            frontLeft.setPower(0);
            frontRight.setPower(-1);
            backRight.setPower(0);
            backLeft.setPower(1);
        }


        if (gamepad1.left_stick_x > 0.5 && gamepad1.left_stick_x < 0.9 && gamepad1.left_stick_y > 0.5 ) // right diagonal back
        {
            frontLeft.setPower(0);
            frontRight.setPower(1);
            backRight.setPower(0);
            backLeft.setPower(-1);
        }

        if (gamepad1.left_stick_x < -0.5 && gamepad1.left_stick_x > -0.9 && gamepad1.left_stick_y > 0.5 ) // left diagonal back
        {
            frontLeft.setPower(1);
            frontRight.setPower(0);
            backRight.setPower(-1);
            backLeft.setPower(0);
        }

        if (gamepad1.right_stick_x > 0.5 && gamepad1.right_stick_y < 0.25 && gamepad1.right_stick_y > -0.25) // turn clockwise
        {
            frontLeft.setPower(1);
            frontRight.setPower(-1);
            backRight.setPower(0);
            backLeft.setPower(0);
        }

        if (gamepad1.right_stick_x < -0.5 && gamepad1.right_stick_y < 0.25 && gamepad1.right_stick_y > -0.25) // turn counterclockwise
        {
            frontLeft.setPower(-1);
            frontRight.setPower(1);
            backRight.setPower(0);
            backLeft.setPower(0);

        }

        else
        {
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
            backLeft.setPower(0);
        }


        if (gamepad2.left_stick_y < -0.5 && gamepad2.left_stick_x < 0.25 && gamepad2.left_stick_x > -0.25 ) // go up
        {
            pinion1.setPower(-1);
            pinion2.setPower(-1);
            x++;
        }
        else if (gamepad2.left_stick_y > 0.5 && gamepad2.left_stick_x < 0.25 && gamepad2.left_stick_x > -0.25) // go down
        {
            pinion1.setPower(1);
            pinion2.setPower(1);

        }
        else
        {
            pinion1.setPower(0);
            pinion2.setPower(0);
        }

        if (gamepad2.right_stick_y < -0.5 && gamepad2.right_stick_x < 0.25 && gamepad2.right_stick_x > -0.25 ) // claw up
        {
            clawgear.setPower(-0.5);
        }
        if (gamepad2.right_stick_y > 0.5 && gamepad2.right_stick_x < 0.25 && gamepad2.right_stick_x > -0.25) // claw down
        {
            clawgear.setPower(0.5);
        }
        else
        {
            clawgear.setPower(0);
        }

      if (gamepad1.b) { //latch
        latch.setPosition(0);
        latch2.setPosition(1);
      }
      if (gamepad1.x) {
        latch.setPosition(1);
        latch2.setPosition(0);
      }

      if (gamepad2.b) {
        claw.setPosition(1);
        claw2.setPosition(0);
      }
      if (gamepad2.x) {
        claw.setPosition(0);
        claw2.setPosition(1);
      }






        telemetry.addData("Status", "Run Time: " + runtime.toString());

        telemetry.addData("Motors", "y (%.2f), x (%.2f)", gamepad1.left_stick_y, gamepad1.left_stick_x);
        telemetry.addData("Motors", "y (%.2f), x (%.2f)", gamepad2.left_stick_y, gamepad2.left_stick_x);
        telemetry.addData("Claw", "y (%.2f), x (%.2f)", gamepad2.right_stick_y, gamepad2.right_stick_x);
        telemetry.addData("X Value", x);
    }


    @Override
    public void stop() {
    }

}
