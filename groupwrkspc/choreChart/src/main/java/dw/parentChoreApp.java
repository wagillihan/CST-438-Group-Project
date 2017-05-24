package dw;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.persistence.*;

@Path("/chore")
public class parentChoreApp {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
		
		@GET
		@Path("/{parentChore}")
		@Produces({MediaType.APPLICATION_JSON})
		public Chore getChore(@PathParam("choreId") int choreId){
			EntityManager em = emf.createEntityManager();
			@SuppressWarnings("unused")
			Chore c = em.find(Chore.class, choreId);
			Chore choreDescription = (Chore) em.createQuery("select c from chore c where choreID = " + choreId).getResultList();
			em.close();
			return choreDescription;
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
		public Response createChore(Chore chore){
			System.out.println("createChore called.");
			Chore c = chore;
			c.print();
			// fix up bidirectional pointers for JPA
			if (c.getChoreDescription() != null ) {
				//for (Child child: p.getChildren()){
					//child.verifyParent(p);
				//}
			}
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			// insert or update Parent and Child objects to database.
			em.merge(c);
			em.getTransaction().commit();  // commit updates to database
			em.close();
			Response rc = Response.ok().build();
			return rc;
			
		}
			
			/*
			 * INSERT INTO chore
			 * VALUES (choreId, childId, choreName, choreDescription, chorePayout, 
			 * dayOfWeek, isRecurring, isComplete, isConfirmedComplete);
			 */
		
		
		
		@POST
		//@Consumes({MediaType.APPLICATION_JSON})
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
