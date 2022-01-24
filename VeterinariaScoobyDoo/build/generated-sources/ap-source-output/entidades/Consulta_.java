package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Consulta.class)
public abstract class Consulta_ {

	public static volatile SingularAttribute<Consulta, String> senha;
	public static volatile SingularAttribute<Consulta, Veterinario> veterinario;
	public static volatile SingularAttribute<Consulta, Dono> dono;
	public static volatile SingularAttribute<Consulta, Date> data;
	public static volatile ListAttribute<Consulta, Consulta> itemConsulta;
	public static volatile SingularAttribute<Consulta, Double> valor;
	public static volatile SingularAttribute<Consulta, Animal> animal;
	public static volatile SingularAttribute<Consulta, Integer> codConsulta;
	public static volatile SingularAttribute<Consulta, String> pagamento;
	public static volatile SingularAttribute<Consulta, String> status;

}

