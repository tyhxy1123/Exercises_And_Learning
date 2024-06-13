//
// This source code is property of the Computer Graphics and Visualization 
// chair of the TU Dresden. Do not distribute in modified or unmodified form! 
// Copyright (C) 2016 CGV TU Dresden - All Rights Reserved
//
#include "bspline.h"

// Initialize the curve and store a reference of the control points.
// Also the degree of the curve is provided through this constructor
bspline::bspline(std::vector<point2d>& control_points, int degree):
abstract_curve(control_points)
{
	this->degree = degree;
}




// The specified "control_points_updated" to adjust the knot vector
// when control points are added or removed
void bspline::control_points_updated()
{
	// Update the knot vector
	calculate_knot_vector();

	// Set the valid range for "t"
	if (u.size() != 0) {
		t_min = u[0];
		t_max = u[u.size()-1];
	}
}




// Calculate the knot vector. This method is called from 
// "control_points_updated"
void bspline::calculate_knot_vector()
{
	// Initialize variables according to the script
	int K = control_points.size();
	int g = degree;
	int n = K - g;

	// Clear and resize the knot vector to the right size
	u.clear();
	u.resize(K + g + 1);

	/*************
	Task 4.1.6.    Fill the knot vector u with the appropriate values for
	               open splines with end point interpolation. The above code
	               initializes variables according to the script.
	Aufgabe 4.1.6. Fuellen Sie den Knotenvektor u mit den passenden Werten
                   fuer offene Splines mit Endpunktinterpolation. Der obige
                   Code initialisiert Variablen wie sie im Skript zu finden sind.
	*************/
}




// Evaluate the basis as a function of the control point "point_num"
// (counted from zero) and the parameter "t".
double bspline::evaluate_basis(int point_num, double t)
{
	/**********
	Task 4.1.6.    Implement the evaluation of the basis function of bsplines
	               for the control point "point_num" at "t". You will find
	               another version with specifyable degree below which you can
	               call from here and use if you want to implement the recursive 
	               approach. The degree of this spline is stored in the variable "degree".
	Aufgabe 4.1.6. Implementieren Sie die Auswertung der Basisfunktion eines
	               BSpline fuer den Kontrollpunkt "point_num" an der Stelle "t".
                   Unten finden Sie eine andere Version mit einstellbarem Grad,
	               die Sie von hier aus aufrufen und verwenden koennen um den rekursiven
	               Berechnungsansatz umzusetzen.
	***********/


	// Remove and replace me with the right return value
	return 0.0;
}




// Another version of the evaluate_basis method with a specifyable
// degree. This method can be used for the recursive evaluation of 
// the basis functions
double bspline::evaluate_basis(int g, int i, double t)
{

	// Remove and replace me with the right return value
	return 0.0;
}



// Set debug text
void bspline::set_text(std::stringstream &stream)
{
	stream<<"Type: BSpline (with degree "<<degree<<")";
}