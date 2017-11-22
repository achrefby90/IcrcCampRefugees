package RefugeeCampSolution.RefugeeCampSolution;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tn.esprit.persistence.Refug;
import tn.esprit.services.RefugeeServicesLocal;




@ManagedBean(name="meBean")
@SessionScoped
public class RefugeeBean {
	
	@EJB
	private RefugeeServicesLocal refugeeServicesLocal;
	
	public Refug refugee = new Refug();
	public Refug refugeeSelected = new Refug();
	private List<Refug> refugees = new ArrayList<>();
	
	public RefugeeBean(){}
		
	public Refug getRefugee() {
		return refugee;
	}

	public void setRefugee(Refug refugee) {
		this.refugee = refugee;
	}

	public Refug getRefugeeSelected() {
		return refugeeSelected;
	}

	public void setRefugeeSelected(Refug refugeeSelected) {
		this.refugeeSelected = refugeeSelected;
	}

	public List<Refug> getRefugees() {
		return refugees;
	}

	public void setRefugees(List<Refug> refugees) {
		this.refugees = refugees;
	}

	@PostConstruct
	public void init() {
		
    refugees = refugeeServicesLocal.GetAllRefug();
	}
	
	public String doAddOrSaveMedicalCare() {
 /*    medicalCare.setMedecinID(1);
	medicalCare.setFirstName("aaaa");
	medicalCare.setLastName("bbbbb");
	medicalCare.setField("aaaa");
	
		refugeeServicesLocal.saveOrupdate(refugee);
		System.out.println(refugee. ());
		System.out.println(medicalCare.getLastName());
		//medicalCares = medicalCareLocal.GetAllMedicalCare();*/
		return "/pages/tt?faces-redirect=true";

	}
	


}
