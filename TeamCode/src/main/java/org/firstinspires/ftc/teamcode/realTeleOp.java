package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "realTeleOpop", group = "Iterative OpMode")
@Disabled
public class realTeleOp extends LinearOpMode {

    private DcMotor pinion1 = null;
    private DcMotor pinion2 = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
    private Servo latch;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override

    public void runOpMode() {
        pinion1 = hardwareMap.dcMotor.get("pinion1");
        pinion2 = hardwareMap.dcMotor.get("pinion2");
        latch = hardwareMap.servo.get("latch");
        //backLeft = hardwareMap.dcMotor.get("backLeft");
        //backRight = hardwareMap.dcMotor.get("backRight");

        pinion1.setDirection(DcMotor.Direction.FORWARD);
        pinion2.setDirection(DcMotor.Direction.REVERSE);
        //backLeft.setDirection(DcMotor.Direction.FORWARD);
        //backRight.setDirection(DcMotor.Direction.REVERSE);


        double ServoPosition;
        double ServoSpeed;


        ServoPosition = 0.5;
        ServoSpeed = 10;
        waitForStart();

        while (opModeIsActive()) {

            // testing the intake
            pinion1.setPower(-gamepad1.left_stick_y);
            pinion2.setPower(-gamepad1.left_stick_y);


            // Use gamepad X and B to open close servo
            if (gamepad2.b) {
                ServoPosition += ServoSpeed;
            }
            if (gamepad2.x) {
                ServoPosition += -ServoSpeed;
            }

            // Keep Servo position in valid range
            ServoPosition = Math.min(Math.max(ServoPosition, 0), 1);
            latch.setPosition(ServoPosition);
            telemetry.addData("Servo", ServoPosition);
            telemetry.update();
            sleep(20);
            telemetry.update();


        }
    }
}
