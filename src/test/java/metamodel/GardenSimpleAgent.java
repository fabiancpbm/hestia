package metamodel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.*;

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

        // Multi-metamodel.Agent metamodel
        MASSystem masSystem = createMAS(sprinkler, temperatureSensor, phSensor, moisturePhSensor, luminositySensor);
        platfotm.setMasSystem(masSystem);

        createBehaviouralFunctions(sprinkler, temperatureSensor, phSensor, moisturePhSensor, luminositySensor);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
        String s = gson.toJson(platfotm);
        System.out.println(s);
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
        Agent physicalAgent = new Agent(++idGenerator, "physical_agent", "The agent responsible to interact with the environment.");
        Agent communicator = new Agent(++idGenerator, "communicator", "The communicator agent");
        Agent mediator = new Agent(++idGenerator, "mediator", "The mediator agent.");
        agents.add(physicalAgent);
        agents.add(communicator);
        agents.add(mediator);

        createPhysicalAgent(physicalAgent, mediator, facetDefinitions);
        createMediatorAgent(mediator, communicator, physicalAgent);
        createCommunicatorAgent(communicator, mediator);

        environment.setAgents(agents);
        return masSystem;
    }

    private static void createPhysicalAgent(Agent physicalAgent, Agent mediator, List<FacetDefinition> facetDefinitions) {
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
        startActions.add(new Action(++idGenerator, "openPercepts", "", order, "percepts", "open"));
        start.setActions(startActions);
        plans.add(start);

        Plan temperature = new Plan(++idGenerator, "temperature(T)", "");
        temperature.setSuccessCondition("");
        order = 0;
        List<Action> temperatureActions = new ArrayList<>();
        temperatureActions.add(new Action(++idGenerator, "blockPercepts", "", order++, "percepts", "block"));
        temperatureActions.add(new MessageAction(++idGenerator, "telltemperature", "", order++, mediator, "temperature(T)"));
        temperatureActions.add(new Action(++idGenerator, "openPercepts", "", order, "percepts", "open"));
        temperature.setActions(temperatureActions);
        plans.add(temperature);

        Plan on = new Plan(++idGenerator, "on", "");
        on.setSuccessCondition("true");
        List<Action> onActions = new ArrayList<>();
        order = 0;
        onActions.add(new Action(++idGenerator, "loggingMyOnAction", "", order++, "print", "Turning the irrigator on."));
        onActions.add(new FacetAction(++idGenerator, "turnOn", "", order, getFacetDefinitionByName(facetDefinitions ,"on")));
        on.setActions(onActions);
        plans.add(on);

        Plan off = new Plan(++idGenerator, "off", "");
        off.setSuccessCondition("true");
        List<Action> offActions = new ArrayList<>();
        order = 0;
        offActions.add(new Action(++idGenerator, "loggingMyOffAction", "", order++, "print", "Turning the irrigator off."));
        offActions.add(new FacetAction(++idGenerator, "turnOff", "", order, getFacetDefinitionByName(facetDefinitions ,"off")));
        off.setActions(offActions);
        plans.add(off);
        physicalAgent.setPlans(plans);
    }

    private static void createMediatorAgent(Agent mediator, Agent communicator, Agent physicalAgent) {
        List<Plan> plans = new ArrayList<>();

        int order = 0;
        Plan temperatureLowerThan10 = new Plan(++idGenerator, "temperature", "Send the temperature to communicator.");
        temperatureLowerThan10.setSuccessCondition("temperature <= 10");
        List<Action> temperatureLowerThan10Actions = new ArrayList<>();
        temperatureLowerThan10Actions.add(new MessageAction(++idGenerator, "sendTemperature", "", order++, communicator, "temperature(too_cold_for_plants)"));
        temperatureLowerThan10Actions.add(new IntentionAction(++idGenerator, "temperatureIntention", "", order, "temperature"));
        temperatureLowerThan10.setActions(temperatureLowerThan10Actions);
        plans.add(temperatureLowerThan10);

        order = 0;
        Plan temperatureGratherThan35 = new Plan(++idGenerator, "temperature", "Send the temperature to communicator.");
        temperatureGratherThan35.setSuccessCondition("temperature <= 35");
        List<Action> temperatureGratherThan35Actions = new ArrayList<>();
        temperatureGratherThan35Actions.add(new MessageAction(++idGenerator, "sendTemperature", "", order++, communicator, "temperature(too_hot_for_plants)"));
        temperatureGratherThan35Actions.add(new IntentionAction(++idGenerator, "temperatureIntention", "", order, "temperature"));
        temperatureGratherThan35.setActions(temperatureGratherThan35Actions);
        plans.add(temperatureGratherThan35);

        order = 0;
        Plan temperatureError = new Plan(++idGenerator, "temperature", "Send the temperature to communicator.");
        List<Action> temperatureErrorActions = new ArrayList<>();
        temperatureErrorActions.add(new IntentionAction(++idGenerator, "temperatureIntention", "", order, "temperature"));
        temperatureGratherThan35.setActions(temperatureErrorActions);
        plans.add(temperatureError);

        order = 0;
        Plan onPlan = new Plan(++idGenerator, "on", "Asking physical_agent to turn on the sprinkler.");
        List<Action> onActions = new ArrayList<>();
        onActions.add(new Action(++idGenerator, "logginngMyOnAction", "", order++, "print", "Turning the irrigator on."));
        onActions.add(new MessageAction(++idGenerator, "sendOnPgysicalAgent", "", order++, physicalAgent, "on"));
        onActions.add(new MessageAction(++idGenerator, "sendOnCommunicator", "", order++, communicator, "irrigator(on)"));
        onActions.add(new BeliefAction(++idGenerator, "removeIrrigatorOffBelief", "", order++, "-", "irrigator(off)"));
        onActions.add(new BeliefAction(++idGenerator, "addIrrigatorOnBelief", "", order, "+", "irrigator(on)"));
        onPlan.setActions(onActions);
        plans.add(onPlan);

        order = 0;
        Plan offPlan = new Plan(++idGenerator, "off", "Asking physical_agent to turn off the sprinkler.");
        List<Action> offActions = new ArrayList<>();
        offActions.add(new Action(++idGenerator, "logginngMyOffAction", "", order++, "print", "Turning the irrigator off."));
        offActions.add(new MessageAction(++idGenerator, "sendOffPgysicalAgent", "", order++, physicalAgent, "off"));
        offActions.add(new MessageAction(++idGenerator, "sendOffCommunicator", "", order++, communicator, "irrigator(off)"));
        offActions.add(new BeliefAction(++idGenerator, "removeIrrigatorOnBelief", "", order++, "-", "irrigator(on)"));
        offActions.add(new BeliefAction(++idGenerator, "addIrrigatorOffBelief", "", order, "+", "irrigator(off)"));
        offPlan.setActions(offActions);
        plans.add(offPlan);

        mediator.setPlans(plans);

        MentalState mentalState = new MentalState(++idGenerator);
        List<Belief> initialBeliefs = new ArrayList<>();
        Belief irrigatorBelief = new Belief(++idGenerator, "irrigatorOff", "irrigator(off)");
        initialBeliefs.add(irrigatorBelief);
        mentalState.setInitialBeliefs(initialBeliefs);
        List<AgentGoal> initialGoals = new ArrayList<>();
        AgentGoal temperatureGoal = new AgentGoal(++idGenerator, "temperature", "temperature", true, temperatureGratherThan35);
        initialGoals.add(temperatureGoal);
        mentalState.setInitialGoals(initialGoals);
        mediator.setInitialState(mentalState);
    }

    private static void createCommunicatorAgent(Agent communicator, Agent mediator) {
        List<Plan> plans = new ArrayList<>();

        int order = 0;
        Plan startPlan = new Plan(++idGenerator, "start", "metamodel.Start plan of the communicator agent.");
        startPlan.setSuccessCondition("true");
        List<Action> startActions = new ArrayList<>();
        startActions.add(new Action(++idGenerator, "loggingMyConnectionToRML", "", order++, "print", "Connecting to RML."));
        startActions.add(new Action(++idGenerator, "connectingToRML", "", order++, "connectToRml", "127.0.0.1", "5500"));
        startActions.add(new IntentionAction(++idGenerator, "startIoTObjectCycle", "", order, "iotObjectCycle"));
        startPlan.setActions(startActions);
        plans.add(startPlan);

        order = 0;
        Plan iotObjectCyclePlan = new Plan(++idGenerator, "iotObjectCycle", "metamodel.Plan to cycle IoT Object.");
        iotObjectCyclePlan.setSuccessCondition("true");
        List<Action> iotObjectCycleActions = new ArrayList<>();
        iotObjectCycleActions.add(new Action(++idGenerator, "sendToRml", "", order++, "sendToRml"));
        iotObjectCycleActions.add(new Action(++idGenerator, "waitInMilliseconds", "", order++, "wait", "1000"));
        iotObjectCycleActions.add(new IntentionAction(++idGenerator, "restartIoTObjectCycle", "", order, "iotObjectCycle"));
        iotObjectCyclePlan.setActions(iotObjectCycleActions);
        plans.add(iotObjectCyclePlan);

        Plan on = new Plan(++idGenerator, "on", "");
        on.setSuccessCondition("true");
        List<Action> onActions = new ArrayList<>();
        order = 0;
        onActions.add(new Action(++idGenerator, "loggingMyOnAction", "", order++, "print", "Asking mediator to turn on the irrigator."));
        onActions.add(new MessageAction(++idGenerator, "sendTurnOn", "", order, mediator, "on"));
        on.setActions(onActions);
        plans.add(on);

        Plan off = new Plan(++idGenerator, "off", "");
        off.setSuccessCondition("true");
        List<Action> offActions = new ArrayList<>();
        order = 0;
        offActions.add(new Action(++idGenerator, "loggingMyOffAction", "", order++, "print", "Asking mediator to turn off the irrigator."));
        offActions.add(new MessageAction(++idGenerator, "sendTurnOff", "", order, mediator, "off"));
        off.setActions(offActions);
        plans.add(off);

        communicator.setPlans(plans);

        MentalState mentalState = new MentalState(++idGenerator);
        List<Belief> initialBeliefs = new ArrayList<>();
        mentalState.setInitialBeliefs(initialBeliefs);
        List<AgentGoal> initialGoals = new ArrayList<>();
        AgentGoal startGoal = new AgentGoal(++idGenerator, "start", "start", true, startPlan);
        initialGoals.add(startGoal);
        mentalState.setInitialGoals(initialGoals);
        communicator.setInitialState(mentalState);
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
        Function onCommand = getFunctionByResourceAndName(sprinkler, "on");
        Function offCommand = getFunctionByResourceAndName(sprinkler, "off");
        Function status = getFunctionByResourceAndName(sprinkler, "status");
        Function valueInCelsius = getFunctionByResourceAndName(temperatureSensor, "valueInCelsius");
        Function valueInPh = getFunctionByResourceAndName(phSensor, "valueInPh");
        Function valueInKgPerM3 = getFunctionByResourceAndName(moisturePhSensor, "valueInKgPerM3");
        Function luminosityStatus = getFunctionByResourceAndName(luminositySensor, "status");

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

    private static void createBehaviouralFunctions(PhysicalResource sprinkler, PhysicalResource temperatureSensor, PhysicalResource phSensor, PhysicalResource moisturePhSensor, PhysicalResource luminositySensor) {
        int order;

        Component valve = getComponentByResourceAndName(sprinkler, "valve");
        Function onFn = getFunctionByComponentAndName(valve, "open");
        if (onFn != null) {
            order = 0;
            List<Block> blocks = new ArrayList<>();
            blocks.add(new WriteInPort(++idGenerator, order, valve.getPins().get(0), new Value(++idGenerator, "", "HIGH", ValueType.SIGNAL)));
            onFn.setBlocks(blocks);
        }

        Function onCommand = getFunctionByResourceAndName(sprinkler, "on");
        if (onCommand != null) {
            order = 0;
            List<Block> blocks = new ArrayList<>();
            blocks.add(new FunctionCall(++idGenerator, order, onFn, new ArrayList<>()));
            onCommand.setBlocks(blocks);
        }

        Function offFn = getFunctionByComponentAndName(valve, "close");
        if (offFn != null) {
            order = 0;
            List<Block> blocks = new ArrayList<>();
            blocks.add(new WriteInPort(++idGenerator, order, valve.getPins().get(0), new Value(++idGenerator, "", "LOW", ValueType.SIGNAL)));
            offFn.setBlocks(blocks);
        }

        Function offCommand = getFunctionByResourceAndName(sprinkler, "off");
        if (offCommand != null) {
            order = 0;
            List<Block> blocks = new ArrayList<>();
            blocks.add(new FunctionCall(++idGenerator, order, offFn, new ArrayList<>()));
            offCommand.setBlocks(blocks);
        }

        Function statusFn = getFunctionByComponentAndName(valve, "status");
        if (statusFn != null) {
            order = 0;
            List<Block> blocks = new ArrayList<>();
            blocks.add(new ReadFromPin(++idGenerator, order, new Value(++idGenerator, "valveStatus", "", ValueType.SIGNAL), valve.getPins().get(0)));
            statusFn.setBlocks(blocks);
        }

        Function statusTopic = getFunctionByResourceAndName(sprinkler, "status");
        if (statusTopic != null) {
            order = 0;
            List<Block> blocks = new ArrayList<>();
            Value statusValue = new Value(++idGenerator, "statusValue", "", ValueType.SIGNAL);
            blocks.add(new Assignment(++idGenerator, order++, statusFn, new ArrayList<>(), statusValue));
            Decision decisionBlock = new Decision(++idGenerator, order, "statusValue == HIGH");
            decisionBlock.getTrueBlocks().add(new Assignment(++idGenerator, 0, new Function(++idGenerator, "=", ""), new ArrayList<>(), new Value(++idGenerator, "", "on", ValueType.TEXT)));
            decisionBlock.getFalseBlocks().add(new Assignment(++idGenerator, 0, new Function(++idGenerator, "=", ""), new ArrayList<>(), new Value(++idGenerator, "", "off", ValueType.TEXT)));
            blocks.add(decisionBlock);
            statusTopic.setBlocks(blocks);
        }

        Component lm35 = getComponentByResourceAndName(temperatureSensor, "lm35");
        Function valueInCelsiusFn = getFunctionByComponentAndName(lm35, "getValue");
        if (valueInCelsiusFn != null) {
            order = 0;
            List<Block> blocks = new ArrayList<>();
            blocks.add(new ReadFromPin(++idGenerator, order, new Value(++idGenerator, "valueInCelsius", "", ValueType.NUMBER), lm35.getPins().get(0)));
            valueInCelsiusFn.setBlocks(blocks);
        }

        Function valueInCelsiusTopic = getFunctionByResourceAndName(temperatureSensor, "valueInCelsius");
        if (valueInCelsiusTopic != null) {
            order = 0;
            List<Block> blocks = new ArrayList<>();
            Value valueInCelsius = new Value(++idGenerator, "valueInCelsius", "", ValueType.NUMBER);
            blocks.add(new Assignment(++idGenerator, order++, valueInCelsiusFn, new ArrayList<>(), valueInCelsius));
            blocks.add(new Assignment(++idGenerator, order, new Function(++idGenerator, "*", ""), Arrays.asList(valueInCelsius, new Value(++idGenerator, "", "2.5", ValueType.NUMBER)), new Value(++idGenerator, "result", "", ValueType.NUMBER)));
            valueInCelsiusTopic.setBlocks(blocks);
        }

        Component phModule = getComponentByResourceAndName(phSensor, "phModule");
        Function getPhValueFn = getFunctionByComponentAndName(phModule, "getValue");
        if (getPhValueFn != null) {
            order = 0;
            List<Block> blocks = new ArrayList<>();
            blocks.add(new ReadFromPin(++idGenerator, order, new Value(++idGenerator, "phValue", "", ValueType.NUMBER), phModule.getPins().get(0)));
            getPhValueFn.setBlocks(blocks);
        }

        Function valueInPhTopic = getFunctionByResourceAndName(phSensor, "valueInPh");
        if (valueInPhTopic != null) {
            order = 0;
            List<Block> blocks = new ArrayList<>();
            Value valueInPh = new Value(++idGenerator, "valueInPh", "", ValueType.NUMBER);
            blocks.add(new Assignment(++idGenerator, order++, getPhValueFn, new ArrayList<>(), valueInPh));
            Value pHVolMultiplied = new Value(++idGenerator, "pHVolMultiplied", "", ValueType.NUMBER);
            blocks.add(new Assignment(++idGenerator, order++, new Function(++idGenerator, "*", ""), Arrays.asList(valueInPh, new Value(++idGenerator, "", "-5.7", ValueType.NUMBER)), pHVolMultiplied));
            blocks.add(new Assignment(++idGenerator, order, new Function(++idGenerator, "+", ""), Arrays.asList(pHVolMultiplied, new Value(++idGenerator, "", "28.4", ValueType.NUMBER)), new Value(++idGenerator, "result", "", ValueType.NUMBER)));
            valueInPhTopic.setBlocks(blocks);
        }

        Component moistureModule = getComponentByResourceAndName(moisturePhSensor, "moistureModule");
        Function valueInKgPerM3Fn = getFunctionByComponentAndName(moistureModule, "getValue");
        if (valueInKgPerM3Fn != null) {
            order = 0;
            List<Block> blocks = new ArrayList<>();
            blocks.add(new ReadFromPin(++idGenerator, order, new Value(++idGenerator, "moistureValue", "", ValueType.NUMBER), moistureModule.getPins().get(0)));
            valueInKgPerM3Fn.setBlocks(blocks);
        }

        Function valueInKgPerM3Topic = getFunctionByResourceAndName(moisturePhSensor, "valueInKgPerM3");
        if (valueInKgPerM3Topic != null) {
            order = 0;
            List<Block> blocks = new ArrayList<>();
            Value moistureValue = new Value(++idGenerator, "moistureValue", "", ValueType.NUMBER);
            blocks.add(new Assignment(++idGenerator, order++, valueInKgPerM3Fn, new ArrayList<>(), moistureValue));
            Decision gratherThan400 = new Decision(++idGenerator, order++, "moistureValue > 400");
            gratherThan400.getTrueBlocks().add(new Assignment(++idGenerator, 0, new Function(++idGenerator, "=", ""), new ArrayList<>(), new Value(++idGenerator, "finalMoistureValue", "dry", ValueType.TEXT)));
            gratherThan400.getFalseBlocks().add(new Assignment(++idGenerator, 0, new Function(++idGenerator, "=", ""), new ArrayList<>(), null));
            blocks.add(gratherThan400);
            Decision lowerThan400GratherThan300 = new Decision(++idGenerator, order++, "moistureValue < 400 && moistureValue > 300");
            lowerThan400GratherThan300.getTrueBlocks().add(new Assignment(++idGenerator, 0, new Function(++idGenerator, "=", ""), new ArrayList<>(), new Value(++idGenerator, "finalMoistureValue", "wet", ValueType.TEXT)));
            lowerThan400GratherThan300.getFalseBlocks().add(new Assignment(++idGenerator, 0, new Function(++idGenerator, "=", ""), new ArrayList<>(), null));
            blocks.add(lowerThan400GratherThan300);
            Decision lowerThan300 = new Decision(++idGenerator, order, "moistureValue < 300");
            lowerThan300.getTrueBlocks().add(new Assignment(++idGenerator, 0, new Function(++idGenerator, "=", ""), new ArrayList<>(), new Value(++idGenerator, "finalMoistureValue", "ideal", ValueType.TEXT)));
            lowerThan300.getFalseBlocks().add(new Assignment(++idGenerator, 0, new Function(++idGenerator, "=", ""), new ArrayList<>(), null));
            blocks.add(lowerThan300);
            valueInKgPerM3Topic.setBlocks(blocks);
        }

        Component ldr = getComponentByResourceAndName(luminositySensor, "ldr");
        Function luminosityStatusFn = getFunctionByComponentAndName(ldr, "status");;
        if (luminosityStatusFn != null) {
            order = 0;
            List<Block> blocks = new ArrayList<>();
            blocks.add(new ReadFromPin(++idGenerator, order, new Value(++idGenerator, "luminosityStatus", "", ValueType.SIGNAL), ldr.getPins().get(0)));
            luminosityStatusFn.setBlocks(blocks);
        }

        Function luminosityStatusTopic = getFunctionByResourceAndName(luminositySensor, "status");
        if (luminosityStatusTopic != null) {
            order = 0;
            List<Block> blocks = new ArrayList<>();
            Value statusValue = new Value(++idGenerator, "luminosityStatus", "", ValueType.SIGNAL);
            blocks.add(new Assignment(++idGenerator, order++, luminosityStatusFn, new ArrayList<>(), statusValue));
            Decision decisionBlock = new Decision(++idGenerator, order, "luminosityStatus == HIGH");
            decisionBlock.getTrueBlocks().add(new Assignment(++idGenerator, 0, new Function(++idGenerator, "=", ""), new ArrayList<>(), new Value(++idGenerator, "", "withLight", ValueType.TEXT)));
            decisionBlock.getFalseBlocks().add(new Assignment(++idGenerator, 0, new Function(++idGenerator, "=", ""), new ArrayList<>(), new Value(++idGenerator, "", "noLight", ValueType.TEXT)));
            blocks.add(decisionBlock);
            luminosityStatusTopic.setBlocks(blocks);
        }
    }

    private static Function getFunctionByComponentAndName(Component component, String functionName) {
        if (component == null || component.getFunctions() == null) {
            return null;
        }
        return component.getFunctions().stream().filter(function -> function.getName().equals(functionName)).findAny().orElse(null);
    }

    private static Component getComponentByResourceAndName(PhysicalResource resource, String componentName) {
        return resource.getComponents().stream().filter(component1 -> component1.getName().equals(componentName)).findAny().orElse(null);
    }

    private static Function getFunctionByResourceAndName(PhysicalResource physicalResource, String functionName) {
        List<Function> functions = new ArrayList<>();
        if (physicalResource.getCommands() != null) {
            functions.addAll(physicalResource.getCommands());
        }
        if (physicalResource.getTopics() != null) {
            functions.addAll(physicalResource.getTopics());
        }
        return functions.stream().filter(function -> function.getName().equals(functionName)).findFirst().orElse(null);
    }

    public static FacetDefinition getFacetDefinitionByName(List<FacetDefinition> facetDefinitions, String name) {
        return facetDefinitions.stream().filter(facetDefinition -> facetDefinition.getName().equals(name)).findAny().orElse(null);
    }
}
