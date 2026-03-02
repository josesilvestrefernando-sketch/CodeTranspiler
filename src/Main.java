import codetranspiler.CodeTranspiler;


void main() throws IOException {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Get ready your folder");
    System.out.println("Make sure the keywords.csv was present inside your folder");
    System.out.println("The input.txt is where you type your code you want to be translated with the designated " +
            "keywords from keywords.csv");
    System.out.print("Enter translator folder name: ");
    String input = scanner.nextLine();
    CodeTranspiler codeTranspiler=new CodeTranspiler(input);
    System.out.println("Check the "+input+"/output.txt");
}


