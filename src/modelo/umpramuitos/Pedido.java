package modelo.umpramuitos;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(nullable = false)
	private Date data;
	
	public Pedido() {
		this(new Date());
	}
	
	
	public Pedido(Date data) {
		super();
		this.data = data;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}
