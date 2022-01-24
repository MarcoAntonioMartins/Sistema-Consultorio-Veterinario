package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile ListAttribute<Produto, Produto> itemConsulta;
	public static volatile SingularAttribute<Produto, Double> valor;
	public static volatile SingularAttribute<Produto, String> nome;
	public static volatile SingularAttribute<Produto, Integer> codProduto;
	public static volatile SingularAttribute<Produto, String> validade;
	public static volatile SingularAttribute<Produto, String> descricao;

}

