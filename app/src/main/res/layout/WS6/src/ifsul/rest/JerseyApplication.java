package ifsul.rest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.jettison.JettisonFeature;

import com.sun.javafx.collections.MappingChange.Map;

public class JerseyApplication extends Application{
	
	
	@Override
	public Set<Object> getSingletons()
	{
		Set<Object> singletons = new HashSet<>();
		singletons.add(new JettisonFeature());
		return singletons;
	}
	
	
	//diz quais pacotes o Jersey irá varrer para localizar anotações JAX-RW
	@Override
	public java.util.Map<String, Object> getProperties()
	{
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("jersey.config.server.provider.packages","ifsul");
		
		return properties;
	}

}
