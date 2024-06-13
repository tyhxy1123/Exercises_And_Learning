//
// This source code is property of the Computer Graphics and Visualization 
// chair of the TU Dresden. Do not distribute in modified or unmodified form! 
// Copyright (C) 2016 CGV TU Dresden - All Rights Reserved
//
#include "rectangle_tool.h"
#include <algorithm>
#include <dda_line_tool.h>


// Initialize the tool and store a reference of a canvas_buffer
rectangle_tool::rectangle_tool(canvas_buffer& canvas): tool_base(canvas)
{
	shape = TS_BOX;
}



// Draw a box from (x0, y0) to (x1, y1)
void rectangle_tool::draw(int x0, int y0, int x1, int y1)
{
	/************
	Additional task: Implement the rasterization of a rectangle that
	                 ranges from (x0, y0) to (x1, y1).
    Zusatzaufgabe:   Implementieren Sie die Rasterisierung eines
	                 Rechtecks, das von (x0, y0) nach (x1, y1) geht.
	*************/
	dda_line_tool tool(canvas);
	tool.draw(x0, y0, x0, y1-1);
	tool.draw(x0, y0, x1-1, y0);
	tool.draw(x1, y1, x0-1, y1);
	tool.draw(x1, y1, x1, y0-1);
}



// Put debug output into the stream "stream" to be displayed in the
// main window
void rectangle_tool::set_text(std::stringstream& stream)
{
	stream<<"Tool: Rectangle (click and drag mouse to draw)";
}