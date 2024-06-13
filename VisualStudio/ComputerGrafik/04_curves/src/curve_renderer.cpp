//
// This source code is property of the Computer Graphics and Visualization 
// chair of the TU Dresden. Do not distribute in modified or unmodified form! 
// Copyright (C) 2015 CGV TU Dresden - All Rights Reserved
//
#include "curve_renderer.h"

#include "GL/glut.h"
#include "GL/freeglut_ext.h"


// Initialize the curve renderer
curve_renderer::curve_renderer()
{
	// no curve yet
	curve = 0;

	// Width and heigth of the basis function graph
	basis_width = 300;
	basis_height = 100;
}


// Set the active curve to render
void curve_renderer::set_curve(abstract_curve *curve)
{
	this->curve = curve;
}



// Sample the curve using "sample_count" samples and store the
// result in the list "samples".
void curve_renderer::sample_curve(int sample_count)
{
	samples.clear();

	// Nothing to sample if there are not at least 2 control points
	if (curve->get_control_points().size()<2)
		return;

	/***************
	Task 4.1.2.    Fill the list "samples" with "sample_count" curve points that
	               are equally sampled along the domain of "t". Mind that this
	               domain does not always have to range from 0 to 1. You will find
	               helper methods in "abstract_curve.h". To add a point to the list 
	               use the "push_back"-Method of the "samples"-object.
	Aufgabe 4.1.2. Fuellen Sie die Liste "samples" mit "sample_count" Kurvenpunkten,
	               die gleichmaessig ueber den Wertebereich von "t" verteilt sind.
				   Beachten Sie, dass dieser Wertebereich nicht zwingend von 0 bis
                   1 gehen muss. Sie finden Helfermethoden in "abstract_curve.h".
                   Um einen Punkt in die Liste hinzuzufuegen nutzen Sie die 
				   "push_back"-Methode des "samples"-Objektes.
   ****************/


	// Remove the following lines
	double step = (curve->get_max_t() - curve->get_min_t()) / 10;

	if (step<=0.0)
		return;

	for (double t=curve->get_min_t(); t<=curve->get_max_t(); t+=step)
		std::cout<<"t: "<<t<<"   point: "<<curve->evaluate(t)<<std::endl;
}


// Render the curve
void curve_renderer::render_curve()
{
	int n = samples.size();

	// Set the color to green
	glColor3d(0, 1, 0);


	/************
	Task 4.1.2.    Connect the points in the "samples" list with a consecutive line.
	               You can get the x and y values of an element with the "x()" and
	               "y()" methods of a point2d object (of which the list consists).
	Aufgabe 4.1.2. Verbinden Sie die Punkte der "samples"-List mit einer geschlossenen
	               Linie. Um die x- und y-Koordinaten eines Punktes zu erhalten nutzen
                   Sie die "x()"- und "y()"-Methoden eines point2d-Objektes (aus denen
                   die Liste besteht).
   *************/
}



// Render the basis functions coordinate system
void curve_renderer::render_basis_axes()
{
	glPushMatrix();
	// Translate to the lower right corner
	glTranslated(glutGet(GLUT_WINDOW_WIDTH) - basis_width - 10, glutGet(GLUT_WINDOW_HEIGHT) - basis_height - 10, 0);

	// Render the axes
	glColor3d(0, 0, 0);
	glBegin(GL_LINES);
	// Vertical 
	glVertex2d(0, basis_height);
	glVertex2d(0, -basis_height);
	// Horizontal
	glVertex2d(0, 0);
	glVertex2d(basis_width, 0);
	// Small vertical at the end of the abszissa
	glVertex2d(basis_width, -3);
	glVertex2d(basis_width, 3);
	glEnd();

	// Render the maximum t
	double t_max = curve->get_max_t();
	if (t_max<=0.0)
		t_max = 1.0;

	std::stringstream s;
	s<<t_max;

	glColor3d(0.0, 0.0, 0.0);
	glRasterPos2i(basis_width-5, 15);
	glutBitmapString(GLUT_BITMAP_HELVETICA_12, reinterpret_cast<const unsigned char*>(s.str().c_str()));

	glPopMatrix();
}


// A helper function you can use to set a color for the basis function
void curve_renderer::set_basis_color(int i)
{
	i++;
	// Set the color according to the basis function to render
	glColor3d(i%2, (i%3)/2.0, (i%5)/6.0);
}



// Render the basis functions
void curve_renderer::render_basis_functions()
{
	double t_max = curve->get_max_t();

	// Only render the axes if the range is too small
	if (t_max <=0.0) {
		render_basis_axes();
		return;
	}

	// Translate to the lower bottom of the screen and scale
	// into the local coordinate system of the basis function graph
	glPushMatrix();
	glTranslated(glutGet(GLUT_WINDOW_WIDTH) - basis_width - 10, glutGet(GLUT_WINDOW_HEIGHT) - basis_height - 10, 0);
	glScaled(basis_width/t_max, -basis_height, 1);


	/**********
	Task 4.1.3.    Render the basis functions of the curve "curve" by rendering
	               a consecutive line for every function. To set the color you
	               can use the method "set_basis_color" with the index of the
	               basis function as parameter. The system is already translated
	               and scaled so you can use "t" and the value of the basis function
	               directly as inputs for the line segments.
	Aufgabe 4.1.3. Rendern Sie die Basisfunktionen der Kurve "curve" indem Sie fuer
	               jede Basisfunktion eine geschlossene Linie zeichnen lassen. Um
                   eine Zeichenfarbe zu setzen koennen Sie die Methode "set_basis_color"
                   verwenden, welcher der Index der darzustellenden Basisfunktionen als
                   Parameter mitgegeben wird. Das Koordinatensystem ist bereits so
                   verschoben und skaliert, dass Sie die Werte fuer "t" und die der
                   Basisfunktionen direkt als Eingaben fuer die Liniensegmente verwenden
                   koennen.
	************/








	glPopMatrix();


	// Render the axes
	render_basis_axes();
}