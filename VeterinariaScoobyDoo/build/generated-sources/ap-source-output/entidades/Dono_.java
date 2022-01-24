package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Dono.class)
public abstract class Dono_ {

	public static volatile SingularAttribute<Dono, Integer> codDono;
	public static volatile SingularAttribute<Dono, String> Celular;
	public static volatile SingularAttribute<Dono, String> telefone;
	public static volatile SingularAttribute<Dono, String> rg;
	public static volatile ListAttribute<Dono, Animal> animais;
	public static volatile SingularAttribute<Dono, String> cpf;
	public static volatile ListAttribute<Dono, Consulta> consultas;
	public static volatile SingularAttribute<Dono, String> nome;
	public static volatile SingularAttribute<Dono, String> email;
	public static volatile SingularAttribute<Dono, String> Endereco;

}

