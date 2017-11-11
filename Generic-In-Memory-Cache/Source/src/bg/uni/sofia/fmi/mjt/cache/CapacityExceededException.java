package bg.uni.sofia.fmi.mjt.cache;

public class CapacityExceededException extends Exception{
	 // Parameterless Constructor
    public CapacityExceededException() {}

    // Constructor that accepts a message
    public CapacityExceededException(String message)
    {
       super(message);
    }
}
