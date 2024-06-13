//
// This source code is property of the Computer Graphics and Visualization 
// chair of the TU Dresden. Do not distribute in modified or unmodified form! 
// Copyright (C) 2016 CGV TU Dresden - All Rights Reserved
//
#include "bezier_curve.h"
#include <math.h>


// Initialize the curve and store a reference of the control points
bezier_curve::bezier_curve(std::vector<point2d>& control_points): abstract_curve(control_points)
{

}




// A helper function to calculate "n choose k"
double bezier_curve::binomial_coefficient(int n, int k)
{
	// ... functionality to be added!

	// Remove and replace me with the right return value
	return 0.0;
}




// Evaluate a basis as a function of the control point "point_num"
// (counted from zero) and the domain parameter t
double bezier_curve::evaluate_basis(int point_num, double t)
{
	int n = control_points.size()-1;
	int i = point_num;

	/**********
	Task 4.1.4.    Implement the evaluation of the Bernstein basis. You can use
	               the method "binomial_coefficient" above (which must also be
	               implemented) for the calculation if wanted.
	Aufgabe 4.1.4. Implementieren Sie die Auswertung der Bernsteinbasis. Sie koennen
	               die Methode "binomial_coeffizient" von oben (die allerdings 
                   ebenfalls noch nicht implementiert ist) fuer die Berechnung
                   nutzen.
   ************/


	// Remove and replace me with the right return value
	return 0.0;
}



// Set debug text
void bezier_curve::set_text(std::stringstream &stream)
{
	stream<<"Type: Bezier";
}