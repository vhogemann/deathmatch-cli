package ws.deathmatch

import org.springframework.context.support.ClassPathXmlApplicationContext

import ws.deathmatch.service.DeathmatchService;

class App {
	
	public static void main(String[] args){
		
		def cli = new CliBuilder(usage: 'deathmatch-cli')
		
		cli.cmd( args: 1, argName: 'cmd', 'One of INSERTCOIN, SHOOT, WALK, UP, DOWN, LEFT or RIGHT' )
		cli.player( args: 1, argName: 'player', '' )
		
		
		def opts = cli.parse(args)
		
		if( ! opts.cmd ){
			cli.usage();
		} else {
			
			def ctx = new ClassPathXmlApplicationContext('applicationContext.xml')
			def service = ctx.getBean(DeathmatchService.class)
			
			println service.sendAndReceive( opts.cmd )	
				
		}
		
	}

}
