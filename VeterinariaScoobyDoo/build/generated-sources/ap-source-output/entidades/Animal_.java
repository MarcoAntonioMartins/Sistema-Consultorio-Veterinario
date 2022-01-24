package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Animal.class)
public abstract class Animal_ {

	public static volatile SingularAttribute<Animal, Integer> idade;
	public static volatile SingularAttribute<Animal, String> tipo;
	public static volatile SingularAttribute<Animal, Dono> dono;
	public static volatile SingularAttribute<Animal, Integer> codAnimal;
	public static volatile SingularAttribute<Animal, String> raca;
	public static volatile SingularAttribute<Animal, String> nome;
	public static volatile ListAttribute<Animal, Animal> consulta;

}

