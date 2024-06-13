#include <iostream>
#include <cmath>

using namespace std;

//vector definition
struct Vector
{
	
	double x, y, z;
	string toString()
	{
		
		return "x: " + to_string(x) +" y: " + to_string(y) + " z: " + to_string(z);
	}
	
	double betrag(){
		return sqrt(x*x + y*y + z*z);
	}
	
	Vector add(Vector v2)
	{
		Vector toReturn;
		toReturn.x = x + v2.x;
		toReturn.y = y + v2.y;
		toReturn.z = z + v2.z;
		
		return toReturn;
	}
	
	double scalarProduct(Vector v)
	{
		double tmp;
		tmp = x * v.x + y * v.y + z * v.z;
		return sqrt(tmp);
	}
	
	double winkel(Vector v)
	{
		double cosinus = scalarProduct(v) / betrag() / v.betrag();
		double radianten = acos(cosinus);
		return radianten * 180 / 3.141592653;
	}
	
	Vector kreuzProduct(Vector v)
	{
		Vector tmp = {y*v.z-z*v.y, z*v.x - x*v.z, x*v.y - y*v.x};
		return tmp;
	}
}Vetor;

int main(int argc, char *argv[]) {
	Vector v1 = {1,2,3};
	Vector v2 = {2,6,12};
	
	cout << "ScarlarProduct is: "<<v1.scalarProduct(v2) << endl;
	cout << "Betrag von v1 ist: " << to_string(v1.betrag()) << endl;
	cout << "Betrag von v2 ist: " << to_string(v2.betrag()) << endl;
	cout << "Winkel zwischen v1 und v2 ist: " << to_string(v1.winkel(v2)) << endl;
	cout << "KreuzProdukt von v1 und v2 ist: " << v1.kreuzProduct(v2).toString() << endl;
}