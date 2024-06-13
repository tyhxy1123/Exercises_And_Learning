//
// This source code is property of the Computer Graphics and Visualization 
// chair of the TU Dresden. Do not distribute in modified or unmodified form! 
// Copyright (C) 2016 CGV TU Dresden - All Rights Reserved
//
#include "dda_line_tool.h"
#include <algorithm>
#include <cmath>


// Initialize the tool and store a reference of a canvas_buffer
dda_line_tool::dda_line_tool(canvas_buffer& canvas): tool_base(canvas)
{
	shape = TS_LINE;
}




// Draw a line from (x0, y0) to (x1, y1)
void dda_line_tool::draw(int x0, int y0, int x1, int y1)
{
	/************
	Task 3.1.1.    Implement the DDA algorithm to raster a line from (x0, y0)
	               to (x1, y1). To set a pixel use "canvas.set_pixel(x, y)" where
				   "x" and "y" is the desired pixel position. This method 
				   handles border violations. Establish the standard case in the
				   first step. If you need to swap the value of two variables you
				   can use the method "std::swap(a, b)".
	Aufgabe 3.1.1. Implementieren Sie den DDA-Algorithmus um eine Linie von
	               (x0, y0) nach (x1, y1) zu rastern. Verwenden Sie
				   "canvas.set_pixel(x, y)" um einen Pixel zu setzen, wobei
				   "x" und "y" den gew�nschten Pixelpositionen entsprechen.
				   Diese Methode behandelt auch Randverletzungen. Stellen Sie zunaechst
				   den Standardfall her. Falls Sie den Wert zweier Variablen vertauschen
				   muessen koennen Sie daf�r die Methode "std::swap(a, b)" verwenden.
   *************/
    int x = x0, y = y0;
    int dx = x1 - x0;
    int dy = y1 - y0;
    int Steps;
    if (abs(dx) > abs(dy))
        Steps = abs(dx);
    else
        Steps = abs(dy);
    float Xincrement = dx / (float) Steps;
    float Yincrement = dy / (float) Steps;
    for(int v=0; v < Steps; v++)
    {
        x = x + Xincrement;
        y = y + Yincrement;
        canvas.set_pixel(x,y);
    }
}




// Put debug output into the stream "stream" to be displayed in the
// main window
void dda_line_tool::set_text(std::stringstream& stream)
{
	stream<<"Tool: DDA-Line (click and drag mouse to draw)";
}