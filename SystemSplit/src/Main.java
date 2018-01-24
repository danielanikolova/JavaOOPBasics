public class Main {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Controller controller = new Controller();

        String[] line = br.readLine().split("[\\(\\)]");
        while (true){
            if ("System Split".equalsIgnoreCase(line[0])){
                System.out.println(controller.systemSplit());
                break;
            }
            String name;
            int capacity;
            int memory;
            String hardwareComponentName;

            String command = line[0];
            switch (command){
                case "RegisterPowerHardware":
                    String[] tokens1 = line[1].split(", ");
                    name = tokens1[0];
                    capacity = Integer.parseInt(tokens1[1]);
                    memory = Integer.parseInt(tokens1[2]);
                    controller.registerPowerHardware(name, capacity, memory);
                    break;
                case "RegisterHeavyHardware":
                    String[] tokens2 = line[1].split(", ");
                    name = tokens2[0];
                    capacity = Integer.parseInt(tokens2[1]);
                    memory = Integer.parseInt(tokens2[2]);
                    controller.registerHeavyHardware(name, capacity, memory);
                    break;
                case "RegisterExpressSoftware":
                    String[] tokens3 = line[1].split(", ");
                    hardwareComponentName = tokens3[0];
                    name = tokens3[1];
                    capacity = Integer.parseInt(tokens3[2]);
                    memory = Integer.parseInt(tokens3[3]);
                    controller.registerExpressSoftware(hardwareComponentName,name, capacity, memory);
                    break;
                case "RegisterLightSoftware":
                    String[] tokens4 = line[1].split(", ");
                    hardwareComponentName = tokens4[0];
                    name = tokens4[1];
                    capacity = Integer.parseInt(tokens4[2]);
                    memory = Integer.parseInt(tokens4[3]);
                    controller.registerLightSoftware(hardwareComponentName,name, capacity, memory);
                    break;
                case "ReleaseSoftwareComponent":
                    String[] tokens = line[1].split(", ");
                    controller.releaseSoftwareComponent(tokens[0], tokens[1]);
                    break;
                case "Analyze":
                    System.out.println(controller.analyze());
                    break;



            }

            line = br.readLine().split("[\\(\\)]");
        }

    }
}
