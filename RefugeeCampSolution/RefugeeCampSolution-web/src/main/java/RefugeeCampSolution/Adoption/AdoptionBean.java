package RefugeeCampSolution.Adoption;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import tn.esprit.persistence.Adoption;
import tn.esprit.persistence.Refug;
import tn.esprit.services.AdoptionServicesLocal;

@ManagedBean(name = "adoptionBean")
@SessionScoped
public class AdoptionBean {

	@EJB
	private AdoptionServicesLocal adoptionServicesLocal;

	public Adoption adopt = new Adoption();
	private List<Adoption> adoptions;
	private Refug refugSelected = new Refug();

	public AdoptionBean() {
	}

	@ManagedProperty(value = "#{userBean}")
	private UserBean usrbean;

	public AdoptionServicesLocal getAdoptionServicesLocal() {
		return adoptionServicesLocal;
	}

	public Refug getRefugSelected() {
		return refugSelected;
	}

	public void setRefugSelected(Refug refugSelected) {
		this.refugSelected = refugSelected;
	}

	public void setAdoptionServicesLocal(AdoptionServicesLocal adoptionServicesLocal) {
		this.adoptionServicesLocal = adoptionServicesLocal;
	}

	public String redirecttoadoption(Refug r)

	{
		this.refugSelected = r;
		return "/AddAdoption?faces-redirect=true";
	}

	public String redirectmail(Adoption adopt)

	{
		adopt.setEtat("Treated");
		adoptionServicesLocal.saveOrupdate(adopt);
		adoptions = adoptionServicesLocal.GetAllAdoptions();

		return "/EmailForm.jsp?faces-redirect=true";

	}

	public String redirectRefugee()

	{

		return "/affichReug?faces-redirect=true";

	}

	public Adoption getAdopt() {
		return adopt;
	}

	public void setAdopt(Adoption adopt) {
		this.adopt = adopt;
	}

	public List<Adoption> getAdoptions() {
		return adoptions;
	}

	public void setAdoptions(List<Adoption> adoptions) {
		this.adoptions = adoptions;
	}

	@PostConstruct
	public void init() {

		adoptions = adoptionServicesLocal.GetAllAdoptions();
		List<Integer> refugees = adoptionServicesLocal.GetAllRefugeeID();
	}

	public void Create() {

		/*
		 * adopt.setDescription(""); adopt.getId().setDateAdoption(new Date());
		 * System.out.println(adopt);
		 * 
		 * adopt.getUser().setId("1"); adopt.getRefug().setRefugID(1);
		 * adopt.setEtat(""); //System.out.println(a);
		 * adoptionServicesLocal.saveOrupdate(adopt);
		 */
	}

	public String CreateAdoption() {
		adopt.setUser(usrbean.getUser());
		adoptionServicesLocal.CreateAdoptions(adopt.getDescription(), "Not Treated", new Date(), usrbean.getUser().getId(), refugSelected.getRefugID());
		adoptions = adoptionServicesLocal.GetAllAdoptions();

		return "/affichReug?faces-redirect=true";

	}

	public String supprimer(Adoption adoption) {

		String navigateTo = "null";
		adoptionServicesLocal.deleteRefug(adoption);
		adoptions = adoptionServicesLocal.GetAllAdoptions();
		navigateTo = "/affichAdoption?faces-redirect=true";
		return navigateTo;
	}

	public UserBean getUsrbean() {
		return usrbean;
	}

	public void setUsrbean(UserBean usrbean) {
		this.usrbean = usrbean;
	}

}
