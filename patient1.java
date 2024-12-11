//Reginald Craft
public class patient1 {
	//required fields for the program
    private String name;
    private String healthInsuranceProvider;
    private double costBeforeTax;
    private double costAfterTax;
    private double copayAmount;

    // Default constructor
    public patient1() {
        // Initialize with default values or leave them empty 
    }

    // Parameterized constructor
    public patient1(String name, String healthInsuranceProvider, double costBeforeTax) {
        this.name = name;
        setHealthInsuranceProvider(healthInsuranceProvider);
        setCostBeforeTax(costBeforeTax);
        calculateTaxes();
        calculateCopayAmount();
    }

    // Copy constructor
    public patient1(patient1 other) {
        this.name = other.name;
        this.healthInsuranceProvider = other.healthInsuranceProvider;
        this.costBeforeTax = other.costBeforeTax;
        this.costAfterTax = other.costAfterTax;
        this.copayAmount = other.copayAmount;
    }

    // accessors and Mutators

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealthInsuranceProvider() {
        return healthInsuranceProvider;
    }

    public void setHealthInsuranceProvider(String healthInsuranceProvider) {
        // This is how we will verify the given values and make sure the program can read it.
        if (healthInsuranceProvider.equals("BCBS") ||  healthInsuranceProvider.equals("Aetna") ||
                 healthInsuranceProvider.equals("Cigna")||  healthInsuranceProvider.equals("Humana")||
                 healthInsuranceProvider.equals("United Health One") || healthInsuranceProvider.equals("Other"));
        {
            this.healthInsuranceProvider = healthInsuranceProvider;
        } 
       
        }
    
//This is how we will get the required cost before tax so we can then multiply it to figure out the cost after tax.
    public double getCostBeforeTax() {
        return costBeforeTax;
    }

    public void setCostBeforeTax(double costBeforeTax) {
        // Verify values. If invalid system will print out so.
        if (costBeforeTax >= 0) {
            this.costBeforeTax = costBeforeTax;
        } else {
            System.out.println("Invalid cost before tax");
        }
    }

    public double getCostAfterTax() {
        return costAfterTax;
    }

    public double getCopayAmount() {
        return copayAmount;
    }

    // Other Methods for the java class.
//prints the health insurance, and money needed before tax, after tax, and copay ammount.
    public void print() {
        System.out.println("Patient: " + name);
        System.out.println("Health Insurance Provider: " + healthInsuranceProvider);
        System.out.println("Cost before tax: $" + costBeforeTax);
        System.out.println("Final Bill Amount: $" + costAfterTax);
        System.out.println("Patient's Copay Amount: $" + copayAmount);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        patient1 patient1 = (patient1) obj;
        return name.equals(patient1.name) &&
                healthInsuranceProvider.equals(patient1.healthInsuranceProvider) &&
                Double.compare(patient1.costBeforeTax, costBeforeTax) == 0 &&
                Double.compare(patient1.costAfterTax, costAfterTax) == 0 &&
                Double.compare(patient1.copayAmount, copayAmount) == 0;
    }

    public void calculateTaxes() {
        double taxRate = 0.08;
        costAfterTax = costBeforeTax * (1 + taxRate);
    }
//calculated copay ammount based on how much much the bill is.
    public void calculateCopayAmount() {
        if (costAfterTax < 100) {
            copayAmount = costAfterTax * 0.3;
        } else if (costAfterTax >= 100 && costAfterTax < 200) {
            copayAmount = 10;
        } else if (costAfterTax >= 200 && costAfterTax < 400) {
            copayAmount = costAfterTax * 0.25;
        } else {
            copayAmount = 35;
        }
    }
}