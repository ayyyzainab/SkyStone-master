package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "NewBlue", group = "")
@Disabled
public class NewBlue extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
    private DcMotor pinion1 = null;
    private DcMotor pinion2 = null;
    private DcMotor clawgear = null;
    private Servo latch;
    private Servo claw;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Ready to run");

        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft  = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        pinion1 = hardwareMap.get(DcMotor.class, "pinion1");
        pinion2  = hardwareMap.get(DcMotor.class, "pinion2");
        clawgear = hardwareMap.get(DcMotor.class, "clawgear");
        latch = hardwareMap.servo.get("latch");
        claw = hardwareMap.servo.get("claw");

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




        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {

                //Drive backwards 1.5 seconds
                frontLeft.setPower(1);
                frontRight.setPower(1);
                backRight.setPower(-1);
                backLeft.setPower(-1);
                sleep(1500);



                //drive backwards
                frontLeft.setPower(-1);
                frontRight.setPower(1);
                backRight.setPower(1);
                backLeft.setPower(-1);
                sleep(1500);

                //latch onto foundation
                latch.setPosition(0.2);
                sleep(5);

                //Turn counterclockwise
                frontLeft.setPower(1);
                frontRight.setPower(-1);
                backRight.setPower(0);
                backLeft.setPower(0);
                sleep(1000);

                //strafe left
                frontLeft.setPower(-1);
                frontRight.setPower(1);
                backRight.setPower(1);
                backLeft.setPower(-1);
                sleep(1500);

                //unlatch
                latch.setPosition(0);
                sleep(5);


                //drive backwards
                frontLeft.setPower(-1);
                frontRight.setPower(-1);
                backRight.setPower(1);
                backLeft.setPower(1);
                sleep(1000);


                //PARK under blue bar
                frontLeft.setPower(0);
                frontRight.setPower(0);
                backRight.setPower(0);
                backLeft.setPower(0);
                sleep(5000);

                telemetry.addData("Path", "Complete");
                sleep(5000);
                telemetry.update();

            }
        }
    }
}
