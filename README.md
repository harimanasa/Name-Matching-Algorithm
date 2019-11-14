# Name-Matching-Algorithm

Each name will have three or more parts.
Mainly First Name, Middle Name (s), Last Name.

Each candidate can also have different alias names which are either same as full name, or sub part of it, or transposition of it.
In all these cases, we need to efficiently match the candidate names on the record with the names known as alias names.
This also includes cases with initials.

Test cases are as below:


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
        
        
Problem courtesy: This question was originally given to me by someone else. I was happy I encountered such a problem so this is my own version of it. I don't have the original version. As a software engineer, I believe we should solve every algorithm that we coe across because problems are repititive.
