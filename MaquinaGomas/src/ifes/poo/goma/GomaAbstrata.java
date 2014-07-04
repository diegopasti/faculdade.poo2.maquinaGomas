package ifes.poo.goma;

public class GomaAbstrata implements Cloneable {
	
	public Object clone(){
		
		Object object = null;
		
		try{
			object = super.clone();
		}
		catch(CloneNotSupportedException e){
			System.out.println("Erro! Falha na clonagem de goma.");
		}
		
		return object;
	}

}
