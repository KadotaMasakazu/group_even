package group_even;

public class AddressBook {
	String personalInfo = "";

	public void registerToAddressBook() {

		System.out.println("From ->registerToAddressBook:"+getPersonalInfo());

	}

	public String getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(String personalInfo) {
		this.personalInfo = personalInfo;
	}

}
