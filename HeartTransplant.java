/*************************************************************************
 *  Compilation:  javac HeartTransplant.java
 *  Execution:    java HeartTransplant < data.txt
 *
 *  @author: Yixin Liang
 *
 *************************************************************************/

public class HeartTransplant {

    /* ------ Instance variables  -------- */

    // Person array, each Person is read from the data file
    private Person[] listOfPatients;//this means make an array of the Person class

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge[] survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause[] survivabilityByCause;

    /* ------ Constructor  -------- */
    
    /*
     * Initializes all instance variables to null.
     */
    public HeartTransplant() {
        // WRITE YOUR CODE HERE
        this.listOfPatients = null;
        this.survivabilityByAge = null;
        this.survivabilityByCause = null;

    }

    /* ------ Methods  -------- */

    /*
     * Inserts Person p into listOfPatients
     * 
     * Returns:  0 if successfully inserts p into array, 
     *          -1 if there is not enough space to insert p into array
     */
    public int addPerson(Person p, int arrayIndex) {

        // WRITE YOUR CODE HERE
        listOfPatients[arrayIndex] = p;//p is a person comes with his ID, AGE, URGENCY, HEART CONDITION,....

        if(listOfPatients[arrayIndex] == p)//maybe not ==, maybe others.maybe compare all p.id, p.age,p.stageOfHealth
            return 0;
        else
            return-1;
    }

    /*
     * 1) Creates the listOfPatients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file.
     *    File Format: ID, Ethinicity, Gender, Age, Cause, Urgency, State of health
     *    Each line refers to one Person.
     * 
     * 3) Inserts each person from file into listOfPatients
     *    Hint: uses addPerson() method                                                                     
     * 
     * Returns the number of patients read from file
     */
    public int readPersonsFromFile(int numberOfLines) {
        // WRITE YOUR CODE HERE
            listOfPatients = new Person[numberOfLines];

            for(int i = 0; i< listOfPatients.length;i++)
            {
                int x = StdIn.readInt();
                int y = StdIn.readInt();
                int a = StdIn.readInt();
                int b = StdIn.readInt();
                int c = StdIn.readInt();
                int d = StdIn.readInt();
                int e = StdIn.readInt();
                listOfPatients[i] = new Person(x,y,a,b,c,d,e);
            }

            return listOfPatients.length;
    }

    /*
     * 1) Creates the survivabilityByAge array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     * 3) Inserts each rate from file into the survivabilityByAge array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByAgeFromFile (int numberOfLines) {

        // WRITE YOUR CODE HERE
        survivabilityByAge = new SurvivabilityByAge[numberOfLines];

        for(int i = 0; i< survivabilityByAge.length;i++)
            {
                int one = StdIn.readInt();
                int two = StdIn.readInt();
                double three = StdIn.readDouble();
                survivabilityByAge[i] = new SurvivabilityByAge(one,two,three);
            }

        return survivabilityByAge.length;
    }

    /*
     * 1) Creates the survivabilityByCause array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     * 3) Inserts each rate from file into the survivabilityByCause array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByCauseFromFile (int numberOfLines) {

        // WRITE YOUR CODE HERE
        survivabilityByCause = new SurvivabilityByCause[numberOfLines];
        
        for(int i = 0; i< survivabilityByCause.length;i++)
        {
            int uno = StdIn.readInt();
            int dos = StdIn.readInt();
            double tres = StdIn.readDouble();
            survivabilityByCause[i] = new SurvivabilityByCause(uno, dos,tres);
        }

        return survivabilityByCause.length;
    }
    
    /*
     * Returns listOfPatients
     */
    public Person[] getListOfPatients() {
        return listOfPatients;
    } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge[] getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause[] getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    /*
     * Returns a Person array in which with every Person that has 
     * age above the parameter age from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with age above the parameter age.
     * 
     * Return null if there is no Person with age above the 
     * parameter age.
     */ 
    public Person[] getPatientsWithAgeAbove(int age) {
        // WRITE YOUR CODE HERE
        int count = 0;
        for(int j = 0; j< listOfPatients.length;j++)
        {
            int check = listOfPatients[j].getAge();
            if(listOfPatients[j].getAge()> age)
                count++;
        }

        //System.out.println("There are totally " + count + " people older than 65.");
        Person[] above = new Person[count];
        int w = 0;
        for(int l = 0; l < listOfPatients.length; l++)
        {
            int b = listOfPatients[l].getAge();
            if(b > age )
            {
                above[w] = listOfPatients[l];
                w++;
            } 
        }
        // for(int d = 0; d< above.length; d++)
        // {
        //     System.out.println(above[d]);
        // }
       
        if(above.length ==0)
            return null;

            return above;
    }
    
    /*
     * Returns a Person array with every Person that has the state of health 
     * equal to the parameter state from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the state of health equal to the parameter state.
     * 
     * Return null if there is no Person with the state of health 
     * equal to the parameter state.
     */ 
    public Person[] getPatientsByStateOfHealth(int state) {

        // WRITE YOUR CODE HERE
        int count = 0;
           for(int j = 0; j< listOfPatients.length;j++)
        {
            int a = listOfPatients[j].getStateOfHealth();
            if(listOfPatients[j].getStateOfHealth()== state)
                count++;
        }

        Person[] sOH = new Person[count];
        int w = 0;
        for(int l = 0; l < listOfPatients.length; l++)
        {
            int b = listOfPatients[l].getStateOfHealth();
            if(b ==state)
            {
                sOH[w] = listOfPatients[l];
                w++;
            } 
        }
        for(int d = 0; d< sOH.length; d++)
        {
            System.out.println(sOH[d]);
        }

        if(sOH.length ==0)
            return null;

        return sOH;

    }

    /*
     * Returns a Person array with every person that has the heart 
     * condition cause equal to the parameter cause from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Person with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Person[] getPatientsByHeartConditionCause(int cause) {

        // WRITE YOUR CODE HERE
        int count = 0;
        for(int j = 0; j< listOfPatients.length;j++)
        {
            int a = listOfPatients[j].getCause();
            if(listOfPatients[j].getCause() == cause)
                count++;
        }

        //System.out.println("There are totally " + count + " people older than 65.");
        Person[] heartC = new Person[count];
        int w = 0;
        for(int l = 0; l < listOfPatients.length; l++)
        {
            int b = listOfPatients[l].getCause();
            if(b == cause )
            {
                heartC[w] = listOfPatients[l];
                w++;
            } 
        }

        if(heartC.length == 0)
            return null;

        return heartC;

    }

    /*
     * Assume there are numberOfHearts available for transplantation surgery.
     * Also assume that the hearts are of the same blood type as the
     * persons on the listOfPatients.
     * This method finds a set of persons to be the recepients of these
     * hearts.
     * 
     * The method returns a Person array from the listOfPatients
     * array that have the highest potential for survivability after
     * the transplant. The array size is numberOfHearts.
     * 
     * If numberOfHeartsAvailable is greater than listOfPatients
     * array size all Persons will receive a transplant.                               //If, If else
     * 
     * If numberOfHeartsAvailable is smaller than listOfPatients
     * array size find the set of people with the highest
     * potential for survivability.
     * 
     * There is no correct solution, you may come up with any set of
     * persons from the listOfPatients array.
     */ 
    public Person[] match(int numberOfHearts) {

        // WRITE YOUR CODE HERE
        Person[] receipients = new Person[numberOfHearts];

        int i =0;
        if(listOfPatients.length <= numberOfHearts)
        {
            while(i< receipients.length)
            {
                receipients[i] = listOfPatients[i];
                i++;
            }
        }

        else if(listOfPatients.length > numberOfHearts)
        {
            int isSeven = 0;
            for(int h = 0; h<listOfPatients.length; h++)
            {
                if(listOfPatients[h].getStateOfHealth() ==7)
                    isSeven++;
            }

            int isSix = 0;
            for(int s = 0; s<listOfPatients.length; s++)
            {
                if(listOfPatients[s].getStateOfHealth() ==6)
                    isSix++;
            }

            int isFive = 0;
            for(int f = 0; f<listOfPatients.length; f++)
            {
                if(listOfPatients[f].getStateOfHealth() ==5)
                    isFive++;
            }

            int count = 0;
            int cou = 0;
            int co = 0;
            Person[] healthiest = new Person[isSeven];
            Person[] healthier = new Person[isSix];
            Person[] healthy = new Person[isFive];
            for(int j = 0; j<listOfPatients.length; j++)
            {
                if(listOfPatients[j].getStateOfHealth() == 7)
                {
                    healthiest[count] = listOfPatients[j];
                    count++;
                }
                if(listOfPatients[j].getStateOfHealth() ==6)
                {
                    healthier[cou] = listOfPatients[j];
                    cou++;
                }
                if(listOfPatients[j].getStateOfHealth() ==5)
                {
                    healthy[co] = listOfPatients[j];
                    co++;
                }
            }

            int ww = 0;
            int www = 0;
            int firstPart = healthiest.length;
            int secondPart = healthiest.length + healthier.length;
            Person[] rankAllHealth = new Person[listOfPatients.length];
            for(int r = 0; r< rankAllHealth.length; r++)
            {
                if(r <firstPart)
                {
                    rankAllHealth[r] = healthiest[r];
                }
                if (r>=firstPart &&  r <secondPart)
                {
                        rankAllHealth[r] = healthier[ww];
                        ww++;
                }
                if(r>= secondPart && r< rankAllHealth.length)
                {
                        rankAllHealth[r] = healthy[www];
                        www++;
                }
            }

            for(int last = 0; last< receipients.length; last++)
            {
                receipients[last] = rankAllHealth[last];
            }
                
        }
            return receipients;
    }

    /*
     * Client to test the methods you write
     */
    public static void main (String[] args) {

        HeartTransplant ht = new HeartTransplant();

        // read persons from file
        int numberOfLines = StdIn.readInt();
        int numberOfReadings = ht.readPersonsFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " patients read from file.");
 
        // read survivability by age from file
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByAgeFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by age lines read from file.");

        // read survivability by heart condition cause from file        
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByCauseFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by cause lines read from file.");

        // list all patients
        for (Person p : ht.getListOfPatients()) {
            StdOut.println(p);
        }

        // list survivability by age rates
        for (SurvivabilityByAge rate : ht.getSurvivabilityByAge()) {
            StdOut.println(rate);
        }

        // list survivability by cause rates
        for (SurvivabilityByCause rate : ht.getSurvivabilityByCause()) {
            StdOut.println(rate);
        }


    }
}
