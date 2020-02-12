/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * This file contains an example of an iterative (Non-Linear) "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all iterative OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="MECANUM4", group="Iterative Opmode")
@Disabled

public class testmecanum extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft  = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);

        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addData("Status", "Initialized");
    }


    @Override
    public void init_loop() {
    }


    @Override
    public void start() {
        runtime.reset();
    }


    @Override
    public void loop() {


        if (gamepad1.left_stick_y < -0.5 && gamepad1.left_stick_x < 0.25 && gamepad1.left_stick_x > -0.25 ) // go forwards
        {
            frontLeft.setPower(-1);
            frontRight.setPower(-1);
            backRight.setPower(1);
            backLeft.setPower(1);
        }
        if (gamepad1.left_stick_y > 0.5 && gamepad1.left_stick_x < 0.25 && gamepad1.left_stick_x > -0.25) // go backwards
        {
            frontLeft.setPower(1);
            frontRight.setPower(1);
            backRight.setPower(-1);
            backLeft.setPower(-1);
        }
        if (gamepad1.left_stick_x < -0.5 && gamepad1.left_stick_y < 0.25 && gamepad1.left_stick_y > -0.25) // go left
        {
            frontLeft.setPower(1);
            frontRight.setPower(-1);
            backRight.setPower(-1);
            backLeft.setPower(1);
        }

        if (gamepad1.left_stick_x > 0.5 && gamepad1.left_stick_y < 0.25 && gamepad1.left_stick_y > -0.25) // go right
        {
            frontLeft.setPower(-1);
            frontRight.setPower(1);
            backRight.setPower(1);
            backLeft.setPower(-1);
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
    /*
        if (gamepad1.right_stick_x > 0.5 && gamepad1.right_stick_y < 0.25 && gamepad1.right_stick_y > -0.25) // turn clockwise
        {
            frontLeft.setPower(-1);
            frontRight.setPower(1);
            backRight.setPower(0);
            backLeft.setPower(0);
        }

        if (gamepad1.right_stick_x < -0.5 && gamepad1.right_stick_y < 0.25 && gamepad1.right_stick_y > -0.25) // turn counterclockwise
        {
            frontLeft.setPower(1);
            frontRight.setPower(-1);
            backRight.setPower(0);
            backLeft.setPower(0);
        }
    */
        if (gamepad1.right_stick_x > 0.5 && gamepad1.right_stick_y < 0.25 && gamepad1.right_stick_y > -0.25) // turn clockwise
        {
            frontLeft.setPower(-1);
            frontRight.setPower(1);
            backRight.setPower(-1);
            backLeft.setPower(1);
        }

        if (gamepad1.right_stick_x < -0.5 && gamepad1.right_stick_y < 0.25 && gamepad1.right_stick_y > -0.25) // turn counterclockwise
        {
            frontLeft.setPower(1);
            frontRight.setPower(-1);
            backRight.setPower(1);
            backLeft.setPower(-1);
        }

        else
        {
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
            backLeft.setPower(0);
        }


        // Show the elapsed game time and wheel power.
        telemetry.addData("Status", "Run Time: " + runtime.toString());

        telemetry.addData("Motors", "y (%.2f), x (%.2f)", gamepad1.left_stick_y, gamepad1.left_stick_x);
        telemetry.addData("Motors", "y (%.2f), x (%.2f)", gamepad2.left_stick_y, gamepad2.left_stick_x);
    }


    @Override
    public void stop() {
    }

}
