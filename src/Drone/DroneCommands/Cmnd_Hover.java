package Drone.DroneCommands;

import java.net.DatagramSocket;
import java.net.InetAddress;

import Drone.Hardware.ATReciever;
import Drone.Helpers.IntToFloat;

/**
 * Sends the "hover" command. to create a new command copy'n'paste this code
 * into a new command class, and change names and the AT_COMMAND_STRING's
 * @author orpheus
 *
 */
public class Cmnd_Hover implements ATCommand 
{

	/** reference to the reciever **/
	private ATReciever motors;
	
	/** command string part 1**/
	private static final String AT_COMMAND_STRING1 = "AT*PCMD=";
	/** command string part 2**/
	private static final String AT_COMMAND_STRING2 = ",1,0,0,0,0";
	
	/**
	 * Default CTOR, initialise stuff
	 */
	public Cmnd_Hover(InetAddress ipAddress, DatagramSocket socket)
	{
		motors = new ATReciever(ipAddress, socket);	
	}
	
	/**
	 * send the command created by concatonating AT_COMMAND_STRING1, the sequence
	 * parameter and AT_COMMAND_STRING2 to the ATReciever
	 */
	@Override
	public void execute(int sequence) throws Exception 
	{
		motors.send_at_cmd(AT_COMMAND_STRING1+sequence+AT_COMMAND_STRING2);
	}

}