/**
 * Filename:    SimpleCalculator.java
 * Author:      Andrew Laing
 * Email:       parisianconnections@gmail.com
 * Date:        9 Feb 2018
 * Description: 
 */
package com.software.laing.calculator;

import javax.swing.SwingUtilities;

public class SimpleCalculator {
	public static void main(String[] args) 
	{
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new CalculatorGUI();
            }
        });

        System.out.println("A Swing GUI should be visible");
	}
}
