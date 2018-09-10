//====================================
// Created: Bob Roos, 3 October 2013
// Modified: Anastasia Kurdia, 11 January 2016
// Objects in the Utensil class have a type, a cost, and a color.
// Methods are provided for retrieving each of these values
// and for setting all but the type to new values. (We aren't allowed to change
// the Utensil's type, so there is no method for it)
//=====================================
public class Utensil
{
    // INSTANCE VARIABLES:
    private String type;   // the type of utensil
    private double cost;   // cost of this utensil, in dollars
    private String color;  // the color of this utensil

    // CONSTRUCTOR:
    //---------------------------------
    // Construct a new Utensil of type t; set other instance variables
    // to default values:
    //---------------------------------
    public Utensil(String t)
    {
        type = t;     // store the type in an instance variable
        cost = -1;    // cost is not known
        color = null; // color is not known
    }

    // METHODS:

    //----------------------------------
    // Set the cost of this utensil to c:
    //----------------------------------
    public void setCost(double c)
    {
        cost = c;
    }

    //----------------------------------
    // Return the cost of this utensil:
    //----------------------------------
    public double getCost()
    {
        return cost;
    }

    //----------------------------------
    // Set the color of this utensil to c:
    //----------------------------------
    public void setColor(String c)
    {
        color = c;
    }

    //----------------------------------
    // Return the color of this utensil:
    //----------------------------------
    public String getColor()
    {
        return color;
    }

    //-----------------------------------
    // Return a string describing this Utensil
    //-----------------------------------
    public String toString()
    {
        return color + " " + type;
    }
}
