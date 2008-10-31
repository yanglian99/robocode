/*******************************************************************************
 * Copyright (c) 2001, 2008 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/cpl-v10.html
 *
 * Contributors:
 *     Flemming N. Larsen
 *     - Initial implementation
 *******************************************************************************/
package testing;


import robocode.*;


/**
 * Based on bug 2212289.
 *
 * Robot provided for the test named TestScanForRobotsWhenHitWall, which tests if onScannedRobot()
 * is called when the radar is turned from within a onHitWall() event.
 *
 * @author Flemming N. Larsen (original)
 */
public class ScanForRobotsWhenHitWall extends Robot {

	@Override
	public void run() {
		// noinspection InfiniteLoopStatement
		for (;;) {
			ahead(10); // make sure we eventually hits a wall to receive onHitWall
		}
	}

	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		out.println("Scanned!!!"); // a robot was scanned -> success!
	}

	@Override
	public void onHitWall(HitWallEvent e) {
		turnRadarRight(360); // when the radar is turned here, at least another robot should be scanned
	}
}
