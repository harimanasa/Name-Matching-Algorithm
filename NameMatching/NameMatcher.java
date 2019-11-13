package NameMatching;

public class NameMatcher {
    public static boolean nameMatch(String[] knownAliases, Name name) {
        for (int i = 0; i < knownAliases.length; i++) {
            Name aliasName = nameBuild(knownAliases[i]);
            if ((aliasName.getFirstName()).equals(name.getFirstName()) && (aliasName.getLastName()).equals(name.getLastName())) {
                if (name.getMiddleName() == null || aliasName.getMiddleName() == null) {
                    return true;
                } else if (aliasName.getMiddleName().equals(name.getMiddleName())) {
                    return true;
                } else {
                    if (aliasName.getMiddleName().length() == 1) {
                        char middleInitial = aliasName.getMiddleName().charAt(0);
                        if (name.getMiddleName().charAt(0) == middleInitial) {
                            return true;
                        }
                    } else if (name.getMiddleName().length() == 1) {
                        char middleInitial = name.getMiddleName().charAt(0);
                        if (aliasName.getMiddleName().charAt(0) == middleInitial) {
                            return true;
                        }
                    }
                }

            }

        }
        return false;
    }

    public static Name nameBuild(String recordName) {
        Name name = new Name();
        String[] nameParts = recordName.split(" ");
        int nameLength = nameParts.length;
        name.setFirstName(nameParts[0]);
        if (nameLength > 2) {
            name.setMiddleName(nameParts[1]);
            name.setLastName(nameParts[2]);
        } else if (nameLength == 2) {
            name.setLastName(nameParts[1]);
        }

        return name;
    }

    public static void assertEqual(boolean expected, boolean result, String errorMessage) {
        if (result != expected) {
            System.out.println(errorMessage);
            System.out.println("expected: " + expected);
            System.out.println("actual: " + result);
            System.out.println("");
        }
    }

    public static void main(String[] args) {

        /* Case 101 : When middle name is missing in name on the record */
        String[] knownAliases = new String[]{"Mark Ramesh Cassandra", "Jim Cassandra"};
        assertEqual(true, nameMatch(knownAliases, nameBuild("Mark Ramesh Cassandra")), "error 101.1");
        assertEqual(true, nameMatch(knownAliases, nameBuild("Jim Cassandra")), "error 101.2");
        assertEqual(false, nameMatch(knownAliases, nameBuild("Mark Ross Cassandra")), "error 101.3");

        /* Case 102 : When middle name is missing in Alias names */
        knownAliases = new String[]{"Mark Cassandra"};
        assertEqual(true, nameMatch(knownAliases, nameBuild("Mark Ramesh Cassandra")), "error 102.1");
        assertEqual(true, nameMatch(knownAliases, nameBuild("Mark Ross Cassandra")), "error 102.2");
        assertEqual(false, nameMatch(knownAliases, nameBuild("Alexander Cassandra")), "error 102.3");

        /* Case 103 : When middle name is missing - another case */
        knownAliases = new String[]{"Mark Ramesh Cassandra"};
        assertEqual(true, nameMatch(knownAliases, nameBuild("Mark Cassandra")), "error 103.1");
        assertEqual(false, nameMatch(knownAliases, nameBuild("Mark Ross Cassandra")), "error 103.2");
        assertEqual(false, nameMatch(knownAliases, nameBuild("Mark Joseph Cassandra")), "error 103.3");

        /* Case 104 : Middle name validation on both sides */
        knownAliases = new String[]{"Mark Ramesh Cassandra", "Mark Ross Cassandra"};
        assertEqual(true, nameMatch(knownAliases, nameBuild("Mark Ramesh Cassandra")), "error 104.1");
        assertEqual(true, nameMatch(knownAliases, nameBuild("Mark Ross Cassandra")), "error 104.2");
        assertEqual(false, nameMatch(knownAliases, nameBuild("Mark Joseph Cassandra")), "error 104.3");

        /* Case 105 : When middle name is an initial */
        knownAliases = new String[]{"Mark Ramesh Cassandra", "Mark D Cassandra"};
        assertEqual(true, nameMatch(knownAliases, nameBuild("Mark R Cassandra")), "error 105.1");
        assertEqual(true, nameMatch(knownAliases, nameBuild("Mark Dwight Cassandra")), "error 105.2");
        assertEqual(false, nameMatch(knownAliases, nameBuild("Mark S Cassandra")), "error 105.3");
        assertEqual(false, nameMatch(knownAliases, nameBuild("Mark Joseph Cassandra")), "error 105.4");
        assertEqual(false, nameMatch(knownAliases, nameBuild("Mark Michael Cassandra")), "error 105.5");

    }
}