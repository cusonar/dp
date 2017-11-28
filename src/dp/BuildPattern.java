package dp;

import java.util.Date;

public class BuildPattern {

	public static void main(String[] args) {
		final Pet.Builder builder = new Pet.Builder();
		final Pet pet = builder
				.withAnimal(Animal.CAT)
				.withPetName("Squidge")
				.withOwnerName("Simon Smith")
				.withAddress("123 High Street")
				.withTelephone("077777777770")
				.withEmailAddress("simon@email.com")
				.build();
		
		System.out.println(pet);
		System.out.println();
	}
}

enum Animal {
	CAT, DOG;
}

class Pet {
	public static class Builder {
		private Animal animal;
		private String petName;
		private String ownerName;
		private String address;
		private String telephone;
		private Date dateOfBirth;
		private String emailAddress;
		
		public Builder withAnimal(final Animal animal) {
			this.animal = animal;
			return this;
		}
		
		public Builder withPetName(final String petName) {
			this.petName = petName;
			return this;
		}
		
		public Builder withOwnerName(final String ownerName) {
			this.ownerName = ownerName;
			return this;
		}
		
		public Builder withAddress(final String address) {
			this.address = address;
			return this;
		}
		
		public Builder withTelephone(final String telephone) {
			this.telephone = telephone;
			return this;
		}
		
		public Builder withDateOfBirth(final Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}
		
		public Builder withEmailAddress(final String emailAddress) {
			this.emailAddress = emailAddress;
			return this;
		}
		
		public Pet build() {
			if (animal == null || 
					petName == null ||
					ownerName == null ||
					address == null ||
					telephone == null) {
				throw new IllegalStateException("Cannot create Pet");
			}
			return new Pet(
					animal,
					petName,
					ownerName,
					address,
					telephone,
					dateOfBirth,
					emailAddress);
		}
	}
	
	private final Animal animal;
	private final String petName;
	private final String ownerName;
	private final String address;
	private final String telephone;
	private final Date dateOfBirth;
	private final String emailAddress;
	
	private Pet(final Animal animal,
			final String petName,
			final String ownerName,
			final String address,
			final String telephone,
			final Date dateOfBirth,
			final String emailAddress) {
		this.animal = animal;
		this.petName = petName;
		this.ownerName = ownerName;
		this.address = address;
		this.telephone = telephone;
		this.dateOfBirth = dateOfBirth;
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Pet [animal=" + animal + ", petName=" + petName + ", ownerName=" + ownerName + ", address=" + address
				+ ", telephone=" + telephone + ", dateOfBirth=" + dateOfBirth + ", emailAddress=" + emailAddress + "]";
	}
	
	

}
