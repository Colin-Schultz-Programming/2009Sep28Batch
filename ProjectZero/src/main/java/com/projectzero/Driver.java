package com.projectzero;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.projectzero.ui.CustomerMenu;
import com.projectzero.ui.EmployeeMenu;

public class Driver {
	static Logger LOGGER = Logger.getLogger(Driver.class);
	private static EmployeeMenu em = new EmployeeMenu();
	private static CustomerMenu cm = new CustomerMenu();
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_CYAN = "\u001B[36m";
	/*
	 * Give them some hefty graphics
	 */

	public static void main(String[] args){
		System.out.println("..........................................................................''''''''''''''...''''''''''''''''''''''.....................................................................'''\r\n"
				+ "...............................................................'....''..''''''''''''''''''''''''''''''''''''''''''''''''.........................'...................................''''\r\n"
				+ "'...........'........................''.........'''''''''''''''''..'''.'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''.........'...'...............''.............'''''\r\n"
				+ "'...................................'''''''''''.''''.'''''''..'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''.''.......'...''.........''...''.............'''''\r\n"
				+ "......................................'''..''''..'''..''''''''..''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''....'...''....''''''''''''............'''''\r\n"
				+ "...............................'''.....''..''''.......''''''...''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''........''....'''''''''''''..........'''''''\r\n"
				+ ".................................''''........................''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''...............''''''''''''''''''.....''''''''''\r\n"
				+ "...........................'''.................................''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''............'''''.......''.''''''.''''''''...'''''''''''\r\n"
				+ "...................'...''........................................''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''.',;;::cccc::;,,''..'''''....'.''''''.''''''''''''''''''''''\r\n"
				+ ".................................................................'.''''''''''''''''''''''''''''''''''''''''''''''''''''''''',:lddxxxxxxxxxxddolc:;,'...........''''''''''''''''''''''''''\r\n"
				+ ".................'.........................................';:,..''''''''''''''''''''''''''''''''''''''''''''''''''''''''';ldxxxdddxxxxxxxxxxxxxxdol;''...''......'''''''''''''''''''''''\r\n"
				+ "......................................................',;:ldxxdl;''''''''''''''''''''''''''''''''''''''''''''''''''''''',cdxxxxxdxxxxxxxxxxxxxxxxddxxdl;..'''''....''''''''''''''''''''''\r\n"
				+ "....................................'''''',,,,,,;;:cclodxxxxxxxxd:''''''''''''''''''''''''''''''''''''''''''''''''''''';oxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxl::,'''''...''''''''''''''''''''''\r\n"
				+ "...................................;odddddddddddxxxxxxxxxxxxxxxdxdc''''''''''''''''''''''''''''''''''''''''''''''''''':dxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxlcdxo:'''''..''''''''''''''''''''''\r\n"
				+ "....................................,ldxxxxxxxxxxxxxxxxxxxxxxxxxdxxl,''''''''''''''''''''''''''''''''''''''''''''''''cdxxxxxxxxxxxxxxxxxxxxxxxxxxxxxdlldxxxxo;''...''''''''''''''''''''''\r\n"
				+ "'..............''.....................;oxxxxxxxxxxxxxxxxxxxxxxxxxxxxo,''''''''''''''''''''''''''''''''''''''''''''',lxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxddxxxxxxxd:'..'''''''''''''''''''''''\r\n"
				+ "'...''.....'''.........................,oxxxxxxxxxxxxxxxxxxxxxxxxxxxxo;.'''''''''''''''''''''''''''''''''''''''''',lxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxdxxxo,.''''''''''''''''''''''''\r\n"
				+ "....''''...'''..........................;dxxxxxxxxdooxxxxxxxxxxxxxxxxxdc:,''''''''''''''''''''''''''''''''''''''';oxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxdlcl;.'''''''''''''''''''''''\r\n"
				+ "'...''''...'''...........................cxxxxxdollodxxxxxxxxxxxxxxxxdoooc,''''''''''''''''''''''''''''''''''''':oxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxdddxc''''''''''''''''''''''''\r\n"
				+ "'..........'''...........................;dxxxdoodxxxdoooddddooodxdoodxkkOkxdl;,''''''''''''''''''''''''''''',coxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxl''''''''''''''''''''''''\r\n"
				+ "''..........'''..........................'oxxxxxxxdoodxkO000OOkxdlcx0000000000Od;'''''''''''''''''''''''''''.;ooooddxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxl''''''''''''''''''''''''\r\n"
				+ "''..........''''.........................'lxxxxxxdodO000000000000OddO00000000000kc''',''''''''''''','',,',;codxxxxddoodxxxddoooooooodxxxxxxxxxxxxxxxxxxxxxxxxxxd:''''''''''''''''''''''''\r\n"
				+ "''...'......''''''.......................,oxxxxxdlx0000000000000000xdk00000000000x;','''''''''''''''',,,cxO000000000Oxooooddxkkkkkxdooldxxxxxxxxxxxxxxxxxxxxxxxl,''''''''''''''''''''''''\r\n"
				+ "'...'''.....'''''''......................;dxxxxdld000000000000000000xdO0000000kodx;',,''''''''''','',';dO0000000000000klok00000000000Odoodxxxxxxxxxxxxxxxxxxxxo,'''''''''''''''''''''''''\r\n"
				+ ".........................................cxxxxxolk000000000000000xdkkok0000000kloo,.''''''''''''.'''',d00000000000000kdx000000000000000Odldxxxxxxxxxxxxxxxxxxo,.'''''''''''''''''''''''''\r\n"
				+ "'.................''....................'lxxxxxdlk00000000000000Ol;dkdk000OOOOOOx:''''''''''''''''''.:dllO0000000000kdx000000000000000O0Ooldxxxxxxxxxxxxxxxxo;'..........................\r\n"
				+ "'''''.'''''''..'..'..'..................'oxxxxxxldO00000000000000000dcodoooooool;'''''''''''''''''''':xodO0000000000xdOOooO00000000000000xldxxxxxxxxxxxxxxxo,''''''''''''''''''''''''''''\r\n"
				+ ";;;;;;;;;;;;;;;;;;;;;;,,................'lxxxxxxdloO00000000000000Odloddxxxxxxxxo;';;,;;,,,;;;;;,,;;,;x0000000000000xdOkcck000000000OO000xldxxxxxxxxxxxxxxl;',,,,,,,,,,,,,,,,,,,,''''''',\r\n"
				+ ";;;;;;;;;;;;;;;;;;;;;;;;,................:xxxxxxxdooxO0000000000Oxoodxxxxxxxxxxxd:,::::;;;:::::::::::;:xkkxxxxkkkkkkdlx00000000000000000Ooldxxxxxxxxxxxxdc,;:;::;;;;;;;;;;;;;;;;;;;;;;;::\r\n"
				+ ":;;;;;;;;;;;;;;;;;;;;;;;;;'..............'lxxxxxxxxdooddxkkkkxddoooxxxxxxxxxxdol:,;::;::::::::::::::::,;loooooooooooolok000000000000000Odldxxxxxdxdloxxdc,;::;;;;;;;;;;;;;;;;;;;;;;;;;;;:\r\n"
				+ ";;;;;;;;;;;;;;;;;;;;;;;;;;;'..............,oxxxxxxxxxxdooooooooodolclcccccllc;,,;::::::::::::::::::::;;lxxxxxxxxxxxxxxoldO000000000O0Oxoodxxxxxxolc;cxd:;;:;;;;;;;;;;;;;;;;;;;;;;;;;;;;;:\r\n"
				+ ",'':cc:c::::::::::::::::::::;'.............'ldxxxxxxxxxxxxxdolcccccccllllooool:,,:ccccccc:::::::::::::;cdxxxxxxxxxxxxxxdoodxkkOOOOkxdoodxxxxxdlllooclo;'',;;;;;,,,;;;;;;;;;;;;;;;;;;;;;;;\r\n"
				+ ":',oxddddddddddddddddddddddddo;..','.......,lxxxxxxxxxxxolcccclloooooooooooooooc;lxkkxxxxxxxxxxxxxxxxxdl:cllooooooooooddxxdoooddooooodxxxxxxdolddxl:c;:c:cddodo:.,cllllllllllllllllllllll\r\n"
				+ ":';oxdddddddddddddddddddddddddc;cdddo;,,,;ldxxxxxxxxxdlc::clooooooooooooooooooooc:oOkkkkkkkkkkkkkkkkkkdcccccccccccccccclllllodxxxxxxxxxxxxxxxxxxxxc,:dkolxkkkkxc';dxdxxddddddddddxxxxxxxx\r\n"
				+ ":';oxdddddddddddddddddddddddxl:odc:clddddxxxxxxxxxxdl::lllooollooooooooooooooooooccdkkkkkkkkkkkkkkkkxlcloooooooooooooooooolc:cccodxxxxxxxxxxxxxoll::dkoldkkkkkxc':oxddddddddddddddddddddx\r\n"
				+ ":';odddddddddddddddddddddddddccddc:lddxxxxxxxxxxxdoc:loooolloooooooooooooooooooool:lkkkkkkkkkkkkkkkxlclooooooooooooooooooooooolc:cldxxxxxxxxxxdolllcldodkkkkkkxl,:odddddddddddddddddddddx\r\n"
				+ ":';odddddddddddddooooooodddddl:lxxooxddxxxxxxxxxdl:cloooooooooooooooooooooooooooooc:dkkkkkkkkkkkkkdccooooooooooooooooooooooooooool::odxxxxxxxxdo:;cl:lkkkkkkkkxc':dxddddddddddddddddddddx\r\n"
				+ ";';odddddddddddddollllllllllllcclllllcoxxxxxxxxxl:loooooooooooooooooooooooooooooool:lkkkkkkkkkkkkdccooooooooooooooooooooooooooooolol:cdxxxxxdoddlldlcdkkkkkkkkxl,:ddooooooooooolooooddddd\r\n"
				+ ";';odddddddddddddddddddddollodddoc:;cdxxxxxxxxxl:coooooooooooooooooooooooooooooooooc:dkkkkkkkkkkxccooooooooooooooooooooooooooooooooll:cdxxdxdlcllllcdkkkkkkkkkkl,:oddddddddoooooooooooodd\r\n"
				+ ";';odddddddddddddddddddddooddddlclc:oxxxxxxxxxdc:oolcc::clollooooooooooooooooooooooc:dkkkkkkkkkkd:looooooooooooooooooooooooooooollllll:lxxxxxxdc:ldxkkkkkkkkkkxl,:odddddddddooodddddddddo\r\n"
				+ ";';oddddddddddddddddddddddddollcloc:oxxxxxxxxxd:cooccolool::clloooooooooooooooooolc:okkkkkkkkkkkxl:loooooooooooooooooollllccccllc::cll:cdxxxxxxllxkkkkkkkkkkkkxl,:dddddddddddddddddddolcc\r\n"
				+ ";';odooooollllllllllooooolllclloooc:dxxxxxxxxxd::ooc:lk00xlddoc:ccccclllllllcccccclxkkkkkkkkkkkkkkdllccccccccccccccllloolcll:;::,'.,loccdxxxxxxlcxkkkkkkkkkkkkxl,:ddddddddddddddddolcc:cc\r\n"
				+ ";',clllcccccccccccccccc::::llll:,;,:dxxxxxxxxxd::oolccldooO00Odxkxoclol::lllllodxkkOOkkkkkkkkkkkkkkkkxxdooolccc::ccc:clc;;;;,,',;,,cll:cxxxxxxxocxkkkkkkkkkkkkxl,:odddddddddddddollcccclo\r\n"
				+ ",',clllllllllllllllllcc:ccclll;..,::ldxxxxxxxxxo::looolc:coodlokOkdxOOd;:dkkkkkkkkkkOkkkkkkkkkkkkkkkkkkkkkkkkxdo:;::,'''''';::::::looc:oxxxxxxxocdkkkkkkkkkkkkxl,:oddddddddddolcclllllolo\r\n"
				+ ",',clllllllc:cllllllc:cllc:llc'',',:clloddxxxxxxo::looooolllccclllclllcc:lxkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkd:clc;;;;;;;::cclloolol:lxxxxxxxxdcdkkkkkkkkkkkkxl,:odooooolllcccllllllllll\r\n"
				+ ",',clllllllc:clllllllllllc:ll;',,,,',:loollodxxxxdlc:clooooloooooooolccclxkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxlcccooooooooooooooolc:lxxxxxxxxxdcokkkkkkkkkkkkxl,;llcccc:;;:clllolllccccc\r\n"
				+ ",',clllllllc:clllllllllllccll,',,,,,,'';ldoolllodxxdlc::clloooooolcccodxkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxl:coooooooooooolc:coxxxxxxxxxxdllkkkkkkkkkkkkxl';lollccccllllllllllllllo\r\n"
				+ ",.,clllllllc:llllllllllllccll,',,,,,,,,'';cdxdolllodxxdolccccccc::odkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkl;ccccclllcccccldxxxxxxxxxxxxxo:loodkkkkkkkkxl',colcclllllllllllllllllo\r\n"
				+ "'..,;,,;;;;,,,;;;;;;;;;;;,,;;'..,,,,,,,,,,',:ldxxdololodxxxxxddocdkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkklcddolllllllodxxxxxxxxxxxxxxxxo:cl:cxkkkkkkkkl',:c::::::::::cc::::::::c\r\n"
				+ "lllllllllllllllclccccccccccc;....',,'''''''''';coxxxxdooooodxxxllkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkllxxxxxxxxxxxxxxxxxxxxddoooodddddkOookkkkkkkkl,,,,,,,,,,,,,,,,,,,,,,,,,\r\n"
				+ "kkkkkkkkkkOkkkkkkkkkkkkkkkxdc''.................':oxxxxxxdolool:okkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkddddddocoxxxxxxxxxxdddooooooodddxkkO000000xoxkkkkkkkxddddddddddddddddddddddddd\r\n"
				+ "kkkkkkkkkkkkkkkkkkkkkkxolll:'.''...',,,,,,,,,'....';lxxxxkxxxdlclodxkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxoclxkkkoldxdooooodddxxxxxkkOO00000000000000Odokkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk\r\n"
				+ "kkkkkkkkkkkkkkkkkkkkdllodxx:.',..',,,,,,,,,,,,,,'...';oxxxxxxxxxxdl:dkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkdoddk00OoodccdxkkOO00000000000000000000000000kodkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk\r\n"
				+ "kkkkkkkkkkkkkkkkkkkocoxxxxo;,,.',,,,,,,,,,,,,,,,,,'..'':oxxxxxxxxl,.lkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxoxOdx00dldlddx00000000000000000000000000000000doxkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk\r\n"
				+ "kkkkkkkkkkkkkkkkkkocoxxxxl;::.',,,,,,,,,,,,,,,,,,,,,'..',:dxxxxo;...'dkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkdoO0xdOxldooOkdO00000000000000000000000000000O0Oookkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk\r\n"
				+ "kkkkkkkkkkkkkkkkkklcdxxxd::c,.,,,,,,,,,,,',,,,,,,,,,,'..'',ldxc......:kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxkkdok00koocllcokkdx00000000000000000000000000000000dlxkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk\r\n"
				+ "Okkkkkkkkkkkkkkkxdc:clol::l:'',,,,,,,,,,,,,,,,''',,,,,,'.''';,.. ....,xOkkkkkkkkkkkkkkkkkxddodddddddddl::oddc;;:lllooolldOO000000000000000000000OO00Okxocokkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk\r\n"
				+ "Okkkkkkkkkkkkkkxlcodoll;;cl:'',,,,,,,,,,,,,,',;;;,,,,,,,'..''..  .....cddxxkkkkkkkkkkkkxoclxkkkOO0kdlcccclodooollodxxxxdcldxxxdxkO00000000000000Okxxdxxxolxkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk\r\n"
				+ "Okkkkkkkkkkkkkkocoxxxxo:cll:'',,,,,,,,,,,,,',ldxxdl:,',,,,'..'..  ....;ooooooooodddxxxdldxokK0OkddoclooolllldxxxdlldxxxdldOOOOkxddddkO00000OkxxxxxxkO000Oolxkkkkkkkkkkkkkkkkkkkkkkkkkkkkk\r\n"
				+ "OkOOkkkkkOkkkkkocdxxxd:;lll:..,,,,,,,,,,,,,',oxxxxxxdl:,',,,'.''.. ....:dxxxxddooooooollooclxdooodxxxxxxxxxlcdxdxoclodooxO00000000OxddddxxxxxxkO000O00OO0Oolxkkkkkkkkkkkkkkkkkkkkkkkkkkkk\r\n"
				+ "OOOkkkkkkkkkkkkdccooo:,clll,..',,,,,,,,,,,,,',cdxxxxxxxoc:;,,'..... ....;dxxxxxxxxxxxxxxxdc:coxxxdddxxxxxxxo:cddoldOOOO00000000000000OdcdOO0000000000000O0kloxkkkkkkkkkkkkkkkkkkkkkkkkkkk\r\n"
				+ "xkOkkOkkOkkkkkkocooll;;lll:''..',,'''''',,,,,,';oxxxxxxxxxdolllcc:;;;,,,,cooooooooooooollc:clllllc:coooooooc;cdddkO00000000000000000000kodO00000O0000000O00xlokkkkkkkkkkkkkkkkkkkkkkkkkkx\r\n"
				+ ";:coxkOkOkkkkkxcoxxxo:clll,',,...,:clccc:;;;;;;:oxxxxxxxxxxxxxxxxxxxxxxxddddddoddddddddddddddddddxxxxddooddxdlx0000000000000000000000000klx000000000000000O0xldkkkkkkkkkkkkkkkkkkkkxdoc:;\r\n"
				+ ",,',,:ldxkOOkkklcdddc;lll:'',,,.'oxxxxxxxxxddddxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxolk0000000000000000000000000dlk0000000000000000Odlxkkkkkkkkkkkkkkkkdol:;,,,,\r\n"
				+ ",,,,,,',:oxkkkOkl:c:':oll,',,,,',oxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxdlo0000000000000000000000000klx000OO00000OO000O0klokkkkkkkkkkkkkkxl;,,,,,,,,");
		System.out.println(ANSI_CYAN +" #     #                                             ######                                     ###           ######                                                            \r\n"
				+ " #     # ###### #####  #####  ###### #####  #####    #     #  ####  #    # ###### #      #      ###  ####     #     # ######   ##   #      ###### #####   ####  #    # # #####  \r\n"
				+ " #     # #      #    # #    # #      #    #   #      #     # #    # #    # #      #      #       #  #         #     # #       #  #  #      #      #    # #      #    # # #    # \r\n"
				+ " ####### #####  #    # #####  #####  #    #   #      ######  #    # #    # #####  #      #      #    ####     #     # #####  #    # #      #####  #    #  ####  ###### # #    # \r\n"
				+ " #     # #      #####  #    # #      #####    #      #       #    # # ## # #      #      #               #    #     # #      ###### #      #      #####       # #    # # #####  \r\n"
				+ " #     # #      #   #  #    # #      #   #    #      #       #    # ##  ## #      #      #          #    #    #     # #      #    # #      #      #   #  #    # #    # # #      \r\n"
				+ " #     # ###### #    # #####  ###### #    #   #      #        ####  #    # ###### ###### ######      ####     ######  ###### #    # ###### ###### #    #  ####  #    # # #     " + ANSI_RESET);
		Scanner userInput = new Scanner(System.in);
		mainMenu(userInput);
	}
	
	private static void mainMenu(Scanner reader) throws InputMismatchException{
		//BasicConfigurator.configure();
		LOGGER.info("Initiating Main Menu");
		/*
		 * 
		 * Offer the user some options upon launching applications.
		 * The options will the user to either the employee side of the application or the customer side.
		 * 
		 * Choosing 1 or 2 will launch the corresponding class for the respective menu
		 * 
		 * All menus are stored within the com.projectzero.ui package.
		 */
		System.out.println("\nHow would you like to proceed?\n");
		System.out.println("1. I am a Customer");
		System.out.println("2. I am an Employee");
		System.out.println("0. Exit System");
		String chosenOption = reader.next();
		switch(chosenOption) {
			case "1":
				LOGGER.info("User accessing customer menu");
				cm.customerMenu(reader);
				mainMenu(reader);
				break;
			case "2":
				LOGGER.info("User accessing employee menu");
				em.employeeMenu(reader);
				mainMenu(reader);
				break;
			case "0":
				System.exit(0);
			default:
				System.out.println("\nInvalid response: Please select a valid numerical option\n");
				mainMenu(reader);
				break;
			}
		}
	}	




	
	
