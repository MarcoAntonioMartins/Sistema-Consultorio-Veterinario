package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Veterinario.class)
public abstract class Veterinario_ {

	public static volatile SingularAttribute<Veterinario, String> telefone;
	public static volatile SingularAttribute<Veterinario, String> endereco;
	public static volatile SingularAttribute<Veterinario, String> rg;
	public static volatile SingularAttribute<Veterinario, String> cpf;
	public static volatile SingularAttribute<Veterinario, Integer> codVeterinario;
	public static volatile SingularAttribute<Veterinario, String> nome;
	public static volatile SingularAttribute<Veterinario, String> cargo;
	public static volatile ListAttribute<Veterinario, Veterinario> consulta;

}

