import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GardenSimpleAgent {
    public static void main(String[] args) {
        Platfotm platfotm = new Platfotm(++idGenerator, "raspberryPiZero", "Raspberry Pi zero 8GB 256GB.");

        // Structural metamodel
        PhysicalResource sprinkler = createSprinkler();
        PhysicalResource temperatureSensor = createTemperatureSensor();
        PhysicalResource phSensor = createPhSensor();
        PhysicalResource moisturePhSensor = createMoistureSensor();
        PhysicalResource luminositySensor = createLuminositySensor();

        List<PhysicalResource> physicalResources = new ArrayList<>();
        physicalResources.add(sprinkler);
        physicalResources.add(temperatureSensor);
        physicalResources.add(phSensor);
        physicalResources.add(moisturePhSensor);
        physicalResources.add(luminositySensor);
        platfotm.setPhysicalResources(physicalResources);

        Microcontroller microcontroller = new Microcontroller();
        Map<String, Microcontroller> microcontrollerMap = new HashMap<>();
        microcontrollerMap.put("/dev/ttyS0", microcontroller);
        platfotm.setPortMicrocontrollerMap(microcontrollerMap);

        // Multi-Agent metamodel
        MASSystem masSystem = createMAS(sprinkler, temperatureSensor, phSensor, moisturePhSensor, luminositySensor);
        platfotm.setMasSystem(masSystem);

        // Behavioural metamodel
        Function onFn;
        Function offFn;
        Function statusFn;
        Command onCommand;
        Command offCommand;
        Topic status;

        Function valueInCelsiusFn;
        Topic valueInCelsius;

        Function getPhValue;
        Topic valueInPh;

        Function valueInKgPerM3Fn;
        Topic valueInKgPerM3;

        Function luminosityStatusFn;
        Topic luminosityStatus;
    }

    private static int idGenerator = 0;
    private static PhysicalResource createSprinkler() {
        PhysicalResource sprinkler = new PhysicalResource(++idGenerator, "sprinkler", "Sprinkler is used to moisten the soil.");

        // Topics
        Topic status = new Topic(++idGenerator, "status", "The state of the Sprinkler (on, off).", "on/off");
        status.setInitialValue("off");
        List<Topic> topics = new ArrayList<>();
        topics.add(status);
        sprinkler.setTopics(topics);

        // Commands
        Command on = new Command(++idGenerator, "on", "Turn on the Sprinkler.");
        Command off = new Command(++idGenerator, "off", "Turn off the Sprinkler.");
        List<Command> commands = new ArrayList<>();
        commands.add(on);
        commands.add(off);
        sprinkler.setCommands(commands);

        // Components
        Component valve = new Component(++idGenerator, "valve", "The solenoid valve with open/close functionalities.");
        Function openFn = new Function(++idGenerator, "open", "Open the valve.");
        Function closeFn = new Function(++idGenerator, "close", "Close the valve.");
        Function statusFn = new Function(++idGenerator, "status", "Status of the valve.");
        List<Function> functions = new ArrayList<>();
        functions.add(openFn);
        functions.add(closeFn);
        functions.add(statusFn);
        valve.setFunctions(functions);

        Pin dataPin = new Pin(++idGenerator, "dataPin", false, false);
        List<Pin> pins = new ArrayList<>();
        pins.add(dataPin);
        valve.setPins(pins);

        List<Component> components = new ArrayList<>();
        components.add(valve);
        sprinkler.setComponents(components);

        return sprinkler;
    }

    private static PhysicalResource createTemperatureSensor() {
        PhysicalResource temperatureSensor = new PhysicalResource(++idGenerator, "temperature_sensor", "The temperature sensor for the environment.");

        // Topics
        Topic valueInCelsius = new Topic(++idGenerator, "valueInCelsius", "The value of the temperature sensor in celsius.", "ºC");
        valueInCelsius.setInitialValue("0.0");
        List<Topic> topics = new ArrayList<>();
        topics.add(valueInCelsius);
        temperatureSensor.setTopics(topics);

        Component lm35 = new Component(++idGenerator, "lm35", "LM35 temperature sensor.");
        Function getValue = new Function(++idGenerator, "getValue", "Get LM35 value.");
        List<Function> functions = new ArrayList<>();
        functions.add(getValue);
        lm35.setFunctions(functions);

        Pin dataPin = new Pin(++idGenerator, "dataPin", true, true);
        List<Pin> pins = new ArrayList<>();
        pins.add(dataPin);
        lm35.setPins(pins);

        List<Component> components = new ArrayList<>();
        components.add(lm35);
        temperatureSensor.setComponents(components);

        return temperatureSensor;
    }

    private static PhysicalResource createPhSensor() {
        PhysicalResource pHSensor = new PhysicalResource(++idGenerator, "pH_sensor", "The pH sensor for the soil's pH.");

        // Topics
        Topic valueInPh = new Topic(++idGenerator, "valueInPh", "The value of the pH sensor.", "");
        valueInPh.setInitialValue("0.0");
        List<Topic> topics = new ArrayList<>();
        topics.add(valueInPh);
        pHSensor.setTopics(topics);

        Component phModule = new Component(++idGenerator, "phModule", "phModule for arduino.");
        Function getValue = new Function(++idGenerator, "getValue", "Get phModule value.");
        List<Function> functions = new ArrayList<>();
        functions.add(getValue);
        phModule.setFunctions(functions);

        Pin dataPin = new Pin(++idGenerator, "dataPin", true, true);
        List<Pin> pins = new ArrayList<>();
        pins.add(dataPin);
        phModule.setPins(pins);

        List<Component> components = new ArrayList<>();
        components.add(phModule);
        pHSensor.setComponents(components);

        return pHSensor;
    }

    private static PhysicalResource createMoistureSensor() {
        PhysicalResource pHSensor = new PhysicalResource(++idGenerator, "moisture_sensor", "The moisture sensor for the soil.");

        // Topics
        Topic valueInKgPerM3 = new Topic(++idGenerator, "valueInKgPerM3", "The value of the moisture sensor.", "kg/m³");
        valueInKgPerM3.setInitialValue("0.0");
        List<Topic> topics = new ArrayList<>();
        topics.add(valueInKgPerM3);
        pHSensor.setTopics(topics);

        Component moistureModule = new Component(++idGenerator, "moistureModule", "moistureModule for arduino.");
        Function getValue = new Function(++idGenerator, "getValue", "Get moistureModule value.");
        List<Function> functions = new ArrayList<>();
        functions.add(getValue);
        moistureModule.setFunctions(functions);

        Pin dataPin = new Pin(++idGenerator, "dataPin", true, true);
        List<Pin> pins = new ArrayList<>();
        pins.add(dataPin);
        moistureModule.setPins(pins);

        List<Component> components = new ArrayList<>();
        components.add(moistureModule);
        pHSensor.setComponents(components);

        return pHSensor;
    }

    private static PhysicalResource createLuminositySensor() {
        PhysicalResource luminositySensor = new PhysicalResource(++idGenerator, "luminosity_sensor", "The luminosity sensor for the environment.");

        // Topics
        Topic status = new Topic(++idGenerator, "status", "The value of the luminosity sensor (noLight, withLight).", "noLight/withLight");
        status.setInitialValue("noLight");
        List<Topic> topics = new ArrayList<>();
        topics.add(status);
        luminositySensor.setTopics(topics);

        Component ldr = new Component(++idGenerator, "ldr", "LDR sensor.");
        Function statusFn = new Function(++idGenerator, "status", "Get luminosity status value.");
        List<Function> functions = new ArrayList<>();
        functions.add(statusFn);
        ldr.setFunctions(functions);

        Pin dataPin = new Pin(++idGenerator, "dataPin", true, true);
        List<Pin> pins = new ArrayList<>();
        pins.add(dataPin);
        ldr.setPins(pins);

        List<Component> components = new ArrayList<>();
        components.add(ldr);
        luminositySensor.setComponents(components);

        return luminositySensor;
    }

    private static MASSystem createMAS(PhysicalResource sprinkler, PhysicalResource temperatureSensor, PhysicalResource phSensor, PhysicalResource moisturePhSensor, PhysicalResource luminositySensor) {
        MASSystem masSystem = new MASSystem(++idGenerator, "garden_mas", "The garden MAS.");

        Environment environment = new Environment(++idGenerator, "garden", "The garden environment.");
        masSystem.setEnvironment(environment);

        // Resources
        List<Resource> resources = createResources(sprinkler, temperatureSensor, phSensor, moisturePhSensor, luminositySensor);
        environment.setResources(resources);

        // FacetDefinitions
        List<FacetDefinition> facetDefinitions = createFacetDefinitions(sprinkler, temperatureSensor, phSensor, moisturePhSensor, luminositySensor);
        environment.setFacets(facetDefinitions);

        // Agents
        List<Agent> agents = new ArrayList<>();
        Agent mediatorAgent = new Agent(++idGenerator, "mediator", "The mediator agent.");
        agents.add(mediatorAgent);
        Agent physicalAgent = createPhysicalAgent(mediatorAgent);
        agents.add(physicalAgent);
        environment.setAgents(agents);
        return masSystem;
    }

    private static Agent createPhysicalAgent(Agent mediator) {
        Agent physicalAgent = new Agent(++idGenerator, "physical_agent", "The agent responsible to interact with the environment.");

        MentalState mentalState = new MentalState(++idGenerator);
        List<Belief> initialBeliefs = new ArrayList<>();
        mentalState.setInitialBeliefs(initialBeliefs);
        List<AgentGoal> initialGoals = new ArrayList<>();
        mentalState.setInitialGoals(initialGoals);
        physicalAgent.setInitialState(mentalState);

        List<Plan> plans = new ArrayList<>();
        Plan start = new Plan(++idGenerator, "start", "");
        start.setSuccessCondition("true");
        int order = 0;
        List<Action> startActions = new ArrayList<>();
        startActions.add(new Action(++idGenerator, "percepts", "", order, "open"));
        start.setActions(startActions);
        plans.add(start);

        Plan temperature = new Plan(++idGenerator, "temperature(T)", "");
        temperature.setSuccessCondition("");
        order = 0;
        List<Action> temperatureActions = new ArrayList<>();
        temperatureActions.add(new Action(++idGenerator, "percepts", "", order++, "block"));
        temperatureActions.add(new MessageAction(++idGenerator, "sendTemperature", "", mediator, order++, "tell", "temperature"));
        temperatureActions.add(new Action(++idGenerator, "percepts", "", order, "open"));
        temperature.setActions(temperatureActions);
        plans.add(temperature);

        Plan on = new Plan(++idGenerator, "on", "");
        on.setSuccessCondition("true");
        List<Action> onActions = new ArrayList<>();
        order = 0;
        onActions.add(new Action(++idGenerator, "print", "", order++, "Turning the irrigator on."));
        onActions.add(new FacetAction(++idGenerator, "on", "", order));
        on.setActions(onActions);
        plans.add(on);

        Plan off = new Plan(++idGenerator, "off", "");
        off.setSuccessCondition("true");
        List<Action> offActions = new ArrayList<>();
        order = 0;
        offActions.add(new Action(++idGenerator, "print", "", order++, "Turning the irrigator off."));
        offActions.add(new Action(++idGenerator, "off", "", order));
        off.setActions(offActions);
        plans.add(off);
        physicalAgent.setPlans(plans);
        return physicalAgent;
    }

    private static List<Resource> createResources(PhysicalResource sprinkler, PhysicalResource temperatureSensor, PhysicalResource phSensor, PhysicalResource moisturePhSensor, PhysicalResource luminositySensor) {
        List<Resource> resources = new ArrayList<>();
        resources.add(createResourceByPhysicalResource(sprinkler));
        resources.add(createResourceByPhysicalResource(temperatureSensor));
        resources.add(createResourceByPhysicalResource(phSensor));
        resources.add(createResourceByPhysicalResource(moisturePhSensor));
        resources.add(createResourceByPhysicalResource(luminositySensor));
        return resources;
    }

    private static Resource createResourceByPhysicalResource(PhysicalResource physicalResource) {
        Resource resource = new Resource(++idGenerator, physicalResource.getName(), physicalResource.getDescription());
        physicalResource.setResource(resource);
        return resource;
    }

    private static List<FacetDefinition> createFacetDefinitions(PhysicalResource sprinkler, PhysicalResource temperatureSensor, PhysicalResource phSensor, PhysicalResource moisturePhSensor, PhysicalResource luminositySensor) {
        Function onCommand = getFunctionByResourceName(sprinkler, "on");
        Function offCommand = getFunctionByResourceName(sprinkler, "off");
        Function status = getFunctionByResourceName(sprinkler, "status");
        Function valueInCelsius = getFunctionByResourceName(temperatureSensor, "valueInCelsius");
        Function valueInPh = getFunctionByResourceName(phSensor, "valueInPh");
        Function valueInKgPerM3 = getFunctionByResourceName(moisturePhSensor, "valueInKgPerM3");
        Function luminosityStatus = getFunctionByResourceName(luminositySensor, "status");

        List<FacetDefinition> facetDefinitions = new ArrayList<>();
        facetDefinitions.add(createFacetDefinitionByFunction(onCommand));
        facetDefinitions.add(createFacetDefinitionByFunction(offCommand));
        facetDefinitions.add(createFacetDefinitionByFunction(status));
        facetDefinitions.add(createFacetDefinitionByFunction(valueInCelsius));
        facetDefinitions.add(createFacetDefinitionByFunction(valueInPh));
        facetDefinitions.add(createFacetDefinitionByFunction(valueInKgPerM3));
        facetDefinitions.add(createFacetDefinitionByFunction(luminosityStatus));
        return facetDefinitions;
    }

    private static FacetDefinition createFacetDefinitionByFunction(Function function) {
        FacetDefinition facetDefinition = new FacetDefinition(++idGenerator, function.getName(), function.getDataType());
        if (function instanceof Command) {
            ((Command) function).setFacetDefinition(facetDefinition);
            facetDefinition.setCanBeChanged(true);
            facetDefinition.setCanBeSensed(true);
            facetDefinition.setCanChange(true);
        } else if (function instanceof Topic) {
            ((Topic) function).setFacetDefinition(facetDefinition);
            facetDefinition.setCanBeChanged(true);
            facetDefinition.setCanBeSensed(true);
            facetDefinition.setCanChange(false);
        }
        facetDefinition.setInitialValue("");
        return facetDefinition;
    }

    private static Function getFunctionByResourceName(PhysicalResource physicalResource, String functionName) {
        List<Function> functions = new ArrayList<>();
        if (physicalResource.getCommands() != null) {
            functions.addAll(physicalResource.getCommands());
        }
        if (physicalResource.getTopics() != null) {
            functions.addAll(physicalResource.getTopics());
        }
        return functions.stream().filter(function -> function.getName().equals(functionName)).findFirst().orElse(null);
    }
}
