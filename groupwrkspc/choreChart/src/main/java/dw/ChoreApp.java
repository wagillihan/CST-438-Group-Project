package dw;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.persistence.*;

@Path("/profile")
public class ChoreApp {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
		
		@GET
		@Path("/{parentId}")
		@Produces({MediaType.APPLICATION_JSON})
		public Parent getParent(@PathParam("parentId") int parentId){
			EntityManager em = emf.createEntityManager();
			Parent p = em.find(Parent.class, parentId);
			int countChildren = p.getChildren().size();  // force a retrieve of lazy relationship of children
			System.out.println(countChildren);
			em.close();
			p.print();
			return p;
		}
		
		@GET
		@Produces({MediaType.APPLICATION_JSON})
		public List<Parent> getParents(){
			System.out.println("getParents called.");
			EntityManager em = emf.createEntityManager();
			@SuppressWarnings("unchecked")
			List<Parent> alist = (List<Parent>) em.createQuery("select p from Parent p").getResultList();
			// note:  the Parent object may not have the children attribute populated,  it might be null due to lazy loading by JPA.
			em.close();
			return alist;
		}

		@POST
		@Consumes({MediaType.APPLICATION_JSON})
		public Response updateParent(Parent p){
			System.out.println("updateParent called.");
			p.print();
			// fix up bidirectional pointers for JPA
			if (p.getChildren() != null) {
				for (Child child: p.getChildren()){
					child.verifyParent(p);
				}
			}
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			// insert or update Parent and Child objects to database.
			em.merge(p);
			em.getTransaction().commit();  // commit updates to database
			em.close();
			Response rc = Response.ok().build();
			return rc;
		}
}
