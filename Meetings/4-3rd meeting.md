[Doubts]
-----------------------------------------------------------------------------------

-----------------------------------------------------------------------------------
- Load balancing / resource allocation / data placement (muito por alto, não é para referir explissitamente mas sim que o algoritmo no final deve ser capaz)
- VM/resource/job scheduling (Não)
- Virtual objects / application decomposition in modules / foglets (Sim este e aplicações por inteiro (tudo numa VM); VOs - menos E2E restrictions vao para a cloud e E2E mais restritos ficam na edge...)
- Handover (Sim)
- Predicted mobility patterns (Não)
- Data/session consistency ?

-----------------------------------------------------------------------------------

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

**Proposed by the professor**

-----------------------------------------------------------------------------------
2015 **An architecture for Load Balancing Techniques for Fog Computing Environment.** ?

This paper **proposes a new architecture based on load balancing algorithm in Fog Computing environment. Users sent the request to the nearby Fog servers which are consistently maintaining the frequently used data. In case, the users don’t get the desired resource in nearby Fog Servers who are also communicating with each other, then that request is forwarded to the cloud servers. To implement this load balancing algorithm they use modified Honey Bee Based algorithm.**

**Note: load balancing ?**

- Nova arquitetura baseada em load balancing em fog;
- User enviam requests para o fog server mais proximo;
- Este guarda os dados mais utilizados;
- Caso não encontre pede aos outros que estão na proximidade;
- Caso não encontre, envia o request para a cloud;
- Usa o algoritmo modified Honey Bee Based.

-----------------------------------------------------------------------------------
2017 **Computing Resource Allocation in Three-Tier IoT Fog Networks: A Joint Optimization Approach Combining Stackelberg Game and Matching.** ?

This paper considers a specific **fog computing network consisting of** a set of **data service operators (DSOs)** each of which controls a set of **fog nodes (FNs)** to provide the required data service to a set of **data service subscribers (DSSs).** They address the problem of **how to allocate the limited computing resources of FNs to all the DSSs to achieve an optimal and stable performance. Therefore, they propose a joint optimization in a distributed fashion. In the framework, they formulate a Stackelberg game to analyze the pricing problem for the DSOs as well as the resource allocation problem for the DSSs.**

**Note: resource allocation ?**

- Rede composta por:
- data service operators (DSOs);
- fog nodes (FNs);
- data service subscribers (DSSs);
- Pretende dar resposta ao problema de como alocar os recursos limitados dos FNs para todos os DSSs;
- Propõe joint optimization de forma distribuída;
- Formulam um Stackelberg game para analisar o problema de pricing para os DSOs e resource allocation para os DSSs.

-----------------------------------------------------------------------------------

2017 **iFogSim: A toolkit for modeling and simulation of resource management techniques in the Internet of Things, Edge and Fog computing environments.** ✓

In this paper they propose a simulator, called iFogSim, to model IoT and Fog environments and measure the impact of resource management techniques in latency, network congestion, energy consumption, and cost.

**Note: important**

-----------------------------------------------------------------------------------

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

**All One Needs to Know about Fog Computing and Related Edge Computing Paradigms: A Complete Survey [references to mobility]**

-----------------------------------------------------------------------------------
[123] 2018 **When clones flock near the fog.** ✓

Abdelwahab et al. design **FogMQ, a self-deploying brokering clones that discover cloud/edge hosting platforms and autonomously migrate clones between them according to self-measured weighted tail end-to-end latency without the need of a central monitoring and control unit**, not having to sacrifice computation offloading gain in cloud platforms. Finally, it is simple and requires no change in existing cloud platforms controllers.

- FogMQ, um self-deploying brokering clones que descobre plataformas cloud/edge e automaticamente migra clones entre eles dependendo do delay end-to-end;
- Não necessita de uma unidade central de controlo e monotorização.

**Note: See again**

-----------------------------------------------------------------------------------
[143] 2018 **Virtual fog: A virtualization enabled fog computing framework for internet of things.** ✓

They propose a layered Fog framework to better support IoT applications through virtualization. The virtualization is divided into object virtualization 
(VOs), network function virtualization and service virtualization. VOs to address the protocol inconsistency (lack of unified networking protocols that leads to exaggerated overhead); Network function virtualization maps standard networking services to VOs, thus, minimize the communication process between consumers and producers by minimizing latency, improving security and scalability; Service virtualization that composes the community and Cloud Apps from various vendors to serve local Fog users with high quality of experience (QoE) but at low cost. At last, Foglets are involved to seamless aggregate multiple independent virtual instances, Fog network infrastructures, and software platforms.

**Note: See again**

-----------------------------------------------------------------------------------
[145] 2017 **Cooperative fog computing for dealing with big data in the internet of vehicles: Architecture and hierarchical resource management.** ?

This paper introduces the challenges of handling big data in the IoV environments. The authors emphasize on the role of fog servers and describe a regional cooperative fog computing (CFC) architecture to support IoV applications. The proposed CFC-IoV architecture consists of two layers. The fog layer is a federation of geographically distributed fog servers, a coordinator server, and the cloud servers, whereas the edge layer includes the vehicular ad hoc network (VANET), IoT applications, and mobile cellular networks.

**Note: See again**

-----------------------------------------------------------------------------------
[149] 2018 **Toward efficient content delivery for automated driving services: An edge computing solution.** ?

They propose a two-level edge computing architecture for automated driving services in order to make full use of the intelligence at the wireless edge (i.e., base stations and autonomous vehicles) for coordinated content delivery. Then they investigate the research challenges of wireless edge caching and vehicular content sharing. Finally, they propose potential solutions to these challenges and evaluate them using real and synthetic traces.

**Note: See again**

-----------------------------------------------------------------------------------
[160] 2018 **Multitier fog computing with large-scale iot data analytics for smart cities.** ?

In this paper a multi tier fog computing model with large-scale data analytics service is proposed for smart cities applications. It is consisted of ad-hoc fogs and dedicated fogs with opportunistic and dedicated computing resources, respectively. They run analytics benchmark experiments over fogs formed by Raspberry Pis with a distributed computing engine to measure computing performance. QoS aware admission control, offloading, and resource allocation schemes are designed to support data analytics services, and maximize analytics service utilities. Availability and cost models of networking and computing resources are taken into account in QoS scheme design. A scalable system level simulator is developed to evaluate the fog-based analytics service and the QoS management schemes.

-----------------------------------------------------------------------------------
[172] 2016 **Vehicular fog computing: A viewpoint of vehicles as the infrastructures.** ✓

Xueshi Hou et al. present the idea of utilizing vehicles as the infrastructures for communication and computation, named vehicular fog computing (VFC), which is an architecture that utilizes a collaborative multitude of end-user clients or near-user edge devices to carry out communication and computation, based on better utilization of individual communication and computational resources of each vehicle. They discussed four types of scenarios of moving and parked vehicles or congested traffic. Also, they point out the advantages against vehicular cloud computing (VCC) and the advantages in scenarios like of emergency operations for natural disaster and terrorist attack.

**Note: introduction, do not present a model, it will serve for introductory references**

-----------------------------------------------------------------------------------
[177] 2017 **Foud: integrating fog and cloud for 5g-enabled v2g networks.** ?

This paper argues that cloud and fog computing using the current mobile networks may not be ideally suited to provide the desired levels of QoS for moving electric vehicles in vehicle-to-grid (V2G) services. They propose a hybrid computing model called "Foud" in which the cloud and fog come together and are made available to the V2G networks in 5G. In the proposed model, the cloud allows virtualized computing, storage, and network resources to be available to the V2G system entities, whereas the fog temporarily integrates the stationary and mobile computing resources located at the edge of V2G networks to expand the computing capacity.

**Note: See again**

-----------------------------------------------------------------------------------
[183] 2017 **Vehicular micro clouds as virtual edge servers for efficient data collection.** ?

The concept of vehicular micro clouds based on map information is introduced, and, by a simulation study, investigated. Vehicular micro clouds are virtual edge servers and are essentially clusters of cars that help to aggregate and preprocess data that is transferred to the cloud.

**Note: See again**

-----------------------------------------------------------------------------------
[186] 2018 **Mobile edge computing via a uav-mounted cloudlet: Optimization of bit allocation and path planning.** ✓

Unmanned aerial vehicles (UAVs) have been considered as means to provide computing capabilities. In this model, UAVs act as fog nodes and provide computing capabilities with enhanced coverage for IoT nodes. The system aims at minimizing the total mobile energy consumption while satisfying QoS requirements of the offloaded mobile application. This architecture is based on a UAV-mounted cloudlet which provides the offloading opportunities to multiple static mobile devices. They aim to minimize the mobile energy consumption, while satisfying QoS requirements and optimize UAV’s trajectory.

**Note: introduction, presents a energetic model, will serve for introductory references**

-----------------------------------------------------------------------------------
[197] 2016 **Incremental deployment and migration of geo-distributed situation awareness applications in the fog.** ✓

Enrique Saurez et al. propose Foglets, a programming model that facilitates distributed programming across fog nodes. Foglets provides APIs for spatio-temporal data abstraction for storing and retrieving application-generated data on the local nodes. Through the API, Foglets processes are set for a certain geospatial region and Foglets manages the application components on the Fog nodes. Foglets is implemented through container-based visualization. The API takes into account QoS and load balancing when migrating persistent (stateful) data between fog nodes. It provides various functionalities: automatically discovers fog computing resources deploys application components onto the fog computing resources commensurate with the latency requirements of each component in the application. It supports multi-application collocation on any compute node. Provides communication APIs for components that are deployed at different physical levels of the network hierarchy to communicate with one another to exchange application state. Lastly, it supports both latency- and workload-driven resource adaptation and state migration over space (geographic) and time to deal with the dynamism in situation awareness application.

-----------------------------------------------------------------------------------
[201] 2015 **Developing iot applications in the fog: a distributed dataflow approach.** ?

This paper proposes a Distributed Dataflow (DDF) programming model for the IoT that utilizes computing infrastructures across the Fog and the Cloud. Also, evaluate their proposal by implementing a DDF framework based on Node-RED (Distributed Node-RED or D-NR), a visual programming tool that uses a flow-based model for building IoT applications.

-----------------------------------------------------------------------------------
[210] 2017 **Cost aware cloudlet placement for big data processing at the edge.** ✗

The locations and number of cloudlets and their servers have a crucial impact on both the deployment cost and E2E delay of user requests. Therefore, Qiang Fan et al.  propose the Cost Aware cloudlet PlAcement in moBiLe Edge computing strategy (CAPABLE) to optimize the tradeoff between the deployment cost and E2E delay. When cloudlets are already placed in the network, they also design a load allocation scheme to minimize the E2E delay of user requests by assigning the workload of each region to the suitable cloudlets.

**Note: introduction**

-----------------------------------------------------------------------------------
[217] 2017**Mobile edge cloud network design optimization.** ✓

Alberto Ceselli et al. present a link-path formulations supported by **heuristics to compute solutions in reasonable time to firstly determining where to install cloudlet** facilities and **secondly assigning sets of access points**, such as base stations **to cloudlets and lastly supporting VM orchestration and considering partial user mobility information, as well as the satisfaction of service-level agreements.** Qualify the advantage in considering mobility for both users and VMs. **Compare two VM mobility modes**, determining that high preference should be given to **live migration and bulk migration** seem to be a feasible alternative on delay-stringent tiny-disk services, such as augmented reality support, and only with further relaxation on network constraints. Also, they focus on the potential medium-term planning of an edge cloud network in mobile access networks. **They study two design cases: 1) network in a static state 2) network state variations in terms of load and service level, caused by user mobility.**

**Note: introduction, see again**

- Utiliza heuristicas para calcular soluções em tempo rasuável;
- Determina onde instalar a cloudlet;
- Assere conjuntos de access points às cloudlets;
- Suporta orquestração de VMs;
- Compara dois tipos de mobilidades: live migration e bulk migration;
- Estuda dois casos: rede num estado estático e rede com variações de carga e níveis de serviço causados pela mbilidade dos utilizadores.

-----------------------------------------------------------------------------------
[231] 2015 **Dynamic service migration and workload scheduling in edge-clouds.** ✓

This paper, Rahul Urgaonkar et al. **present a model to optimize operational costs while providing rigorous performance guarantees as a sequential decision-making Markov Decision Problem (MDP).** This model is different from the traditional solution methods (such as dynamic programming) that require extensive statistical knowledge and are computationally prohibitive. **First they establish a decoupling property of the MDP that reduces it to two independent MDPs. Then, using the technique of Lyapunov optimization over renewals they design an online control algorithm that is provably cost-optimal.** When the decoupling property holds, it enables the design of simple online control algorithms that do **not require any knowledge of the underlying statistics of the MDPs**, yet are provably optimal. This technique was applied to **dynamic service migration** and workload scheduling.

**Note: introduction, not very important - [232] its better**

- Modelo de otimização de custos operacionais garantindo uma performance rigorosa como um sequencia de tomadas de decisão Markov Decision Problem (MDP);
- Estabelecem uma propriedade de desacopulamento do MDP que reduz o em dois MDPs independentes;
- Depois, utilizam a tecnica Lyapunov optimization;
- É um algoritmo distribuído que é cost-optimal;
- Não requer conhecimentos estatisticos;
- É utilizado para dynamic service migration e workload scheduling.

-----------------------------------------------------------------------------------
[232] 2016 **Segue: Quality of service aware edge cloud service migration.** ✓

Wuyang Zhang et al. propose **SEGUE, a service that achieves optimal migration decisions by providing a long-term optimal QoS to mobile users. This model arises to overcome the limitations of previous studies that propose a static distance-based Markov Decision Process (MDP) for optimizing migration decisions that although works, it fails to consider dynamic network and server states.** **SEGUE is a MDP-based model** which incorporates the two dominant factors in making migration decisions: 1) network state, and 2) server state. **On top of that SEGUE answers the question of when to recalculate the MDP model, because to short intervals would create heavy overhead, and long intervals may translate into lazy migration. SEGUE adopts a QoS aware scheme to activate the MDP model when a QoS violation is predicted to solve for the when to migrate variable. Two components of SEGUE work together to achieve this. One module monitors network states, server workloads and user mobility and the other is responsible for QoS prediction. This allows SEGUE to avoid unnecessary migration costs and bypass any possible QoS violations.**

**Note: introduction, important**

- SEGUE é um serviço que consegue decisões de migração otimas fornecendo long-term optimal QoS aos utilizadores móveis;
- É introduzido para ultrapassar as limitações dos estudos anteriores que propõem MDP baseado na distância;
- Ao contrário desses estudos, este tem em conta os fatores network state e server state;
- Ainda responde à questão de quando recalcular o algoritmo;
- Um intervalo de tempo muito pequeno resulta em grandes overheads;
- Um intervalo muito grande resulta em azy migration;
- SEGUE é dividido em dois componentes, um que monitoriza network states, server workloads e user mobility;
- O outro é responsável por QoS prediction.
- Sempre que é previsto uma violação de QoS, o MDP é activado;
- Resulta em evitar migrações não necessárias e evita violações de QoS.

-----------------------------------------------------------------------------------
[234] 2017 **Optimizing service replication for mobile delay-sensitive applications in 5g edge network.** ?

To guarantee the strict latency requirements, new solutions are required to cope with the user mobility in a distributed edge cloud environment. The use of proactive replication mechanism seems promising to avoid QoE degradation during service migration between different edge nodes. However, accounting for the limited resources of edge micro data-centers, appropriate optimization solutions must be developed to reduce the cost of service deployment, while guaranteeing the desired QoE. In this paper, Ivan Farris et al., by leveraging on prediction schemes of user mobility patterns, have proposed two linear optimization solutions for replication-based service migration in cellular 5G networks: the min-RM approach aims at minimizing the QoE degradation during user handover; min-NSR approach favors the reduction of service replication cost. Simulation results proved the efficiency of each solution in achieving its design goal and provides useful information for network and service orchestrators in nextgeneration 5G cloud-based networks.

-----------------------------------------------------------------------------------
[237] 2013 **Migcep: operator migration for mobility driven distributed complex event processing.** ✓

Most work studying the placement of operators in such an environment completely disregards the migration costs. However, the mobility of users requires frequent migration of operators, together with possibly large state information, to meet latency restrictions and save bandwidth in the infrastructure. In this papers, Beate Ottenwälder et al. **present a placement and migration method** for providers of infrastructures that incorporate cloud and fog resources. **It ensures application-defined end-to-end latency restrictions and reduces the network utilization by planning the migration ahead of time using predicted mobility patterns.** Furthermore, present how the application **knowledge of the complex event processing (CEP) system can be used to improve current live migration techniques for Virtual Machines (VMs) to reduce the required bandwidth during the migration.** First, **it allows us to amortize the migration costs by selecting migration targets that ensure a low expected network utilization for a sufficiently long time.** Second, it allows us to serialize the operator for the migration and migrating parts of the operator a priori in away where unnecessary events are not migrated and bandwidth is reduced.

**Note: it uses statistics to calculate the migration in advance**

- Usa estatisticas (padrões de mobilidade previstos) para o planeamento de antemão;
- Assegura as restrições de latência end-to-end;
- Complex event processing (CEP) pode ser utilizado para melhorar as técnicas de live migration de VMs;
- Minimiza custos de migração selecionando alvos que asseguram uma previsão de utilização de rede reduzida durante um tempo suficientemente longo;

-----------------------------------------------------------------------------------
[238] 2015 **Developing iot applications in the fog: a distributed dataflow approach.** ?

To address challenges of the intrinsic nature of the IoT (heterogeneous devices/resources, a tightly coupled perception-action cycle and widely distributed devices and processing), they propose a Distributed Dataflow (DDF) programming model for the IoT that utilities computing infrastructures across the Fog and the Cloud. Also, they evaluate their proposal by implementing a DDF framework based on Node-RED (Distributed Node-RED or D-NR), a visual programming tool that uses a flow-based model for building IoT applications.

-----------------------------------------------------------------------------------
[243] 2017 **Follow me fog: Toward seamless handover timing schemes in a fog computing environment.** ✓

The authors observe that traditional mobile network handover mechanisms cannot handle the demands of fog computation resources and the low-latency requirements of mobile IoT applications. The authors propose Follow Me Fog framework to guarantee service continuity and reduce latency during handovers. The key idea proposed is to continuously monitor the received signal strength of the fog nodes at the mobile IoT device, and to trigger pre-migration of computation jobs before disconnecting the IoT device from the existing fog node.

-----------------------------------------------------------------------------------
[244] 2017 **Efficient service handoff across edge servers via docker container migration.** ✓

Present a novel service handoff system which seamlessly migrates offloading services to the nearest edge server, while the mobile client is moving. Service handoff is achieved via container migration. They have identified an important performance problem during Docker container migration, proposing a migration method which leverages the layered storage system to reduce file system synchronization overhead, without dependence on the distributed file system.

-----------------------------------------------------------------------------------
[246] 2016 **Primal: Profit maximization avatar placement for mobile edge computing.** ✓

User Equipment (UE) are moving in the network, and so the E2E (between UE and its Avatar) may become worse, degrading QoS. The live Avatar migration is triggered to adjust the location of the UE’s Avatar. However, the **migration process consumes extra resources** of the Avatar that may degrade the performance of applications running in the Avatar. By considering the **gain (i.e., the end-to-end delay reduction)** and the **cost (i.e., the migration overheads)** of the live Avatar (a software clone; high performance Virtual Machine (VM) located in a cloudlet) migration, Xiang Sun et al. propose a PRofIt Maximization Avatar pLacement **(PRIMAL) strategy for the cloudlet network in order to optimize the trade-off between the migration gain and the migration cost by selectively migrating the Avatars to their optimal locations.**

- PRIMAL é uma estratégia para redes de cloudlets com o objetivo de otimizar o trade-off entre:
- gain (i.e., the end-to-end delay reduction);
- cost (i.e., the migration overheads);
- Desta forma migra os Avatars para as localizações ótimas.

-----------------------------------------------------------------------------------
[247] 2017 **Towards efficient edge cloud augmentation for virtual reality mmogs.** ✓

**One problem remains unsolved: how to distribute the work among the user device, the edge clouds, and the center cloud to meet all three requirements especially when users are mobile.** Wuyang Zhang et al. **propose a hybrid gaming architecture that achieves clever work distribution.** It places local view change updates on edge clouds for immediate responses, frame rendering on edge clouds for high bandwidth, and global game state updates on the center cloud for user scalability. In addition, they propose an efficient service placement algorithm based on a Markov decision process. **This algorithm dynamically places a user’s gaming service on edge clouds while the user moves through different access points taking into account the presence of dynamic network states and server workload states, and user mobility.** However, **unlike many of the service migration solutions which assumes an ignorable service transition time, they acknowledge that it is impossible to migrate an edge service from one edge to another instantly given the size of a VR game world. Therefore, they propose a mechanism to ensure a new edge cloud is activated when a player connects to the new one. It also co-places multiple users to facilitate game world sharing and reduce the overall migration overhead.** Also, they derive optimal solutions and devise efficient heuristic approaches and study different algorithm implementations to speed up the runtime.

**Note: introduction, important following the MDP field**

- Trata o problema de como distribuir o trabalho entre user device, edge devices e a cloud quando os utilizadores são móveis;
- Propõe um algoritmo que automaticamente migra as VMs para outras edge clouds enquanto o utilizador se move;
- Tem em conta dynamic network states, server workload states, e user mobility (usa MDP);
- Não ignora o facto das migrações terem um custo temporal então propõe um mecanismo para suavizar esta transição.

-----------------------------------------------------------------------------------
[254] 2018 **Move with me: Scalably keeping virtual objects close to users on the move.** ?

With the state-of-the-art virtualization technologies, services can be implemented in modular software as a graph/chain of portable VOs that can be dynamically migrated around the Telco infrastructure. It is proposed a VO clustering and migration policy that jointly considers user proximity and inter-VO affinity to scalably support user mobility, while allowing service differentiation among users.

-----------------------------------------------------------------------------------
[261] 2017 **Virtual machine placement for backhaul traffic minimization in fog radio access networks.** ✓

How to appropriately place virtual machines (VMs) into fog nodes in F-RAN systems is very challenging, and will significantly affect the bandwidth consumption of backhaul links. Thus, Ya-Ju Yu et al. analyse the VM placement problem in fog radio access networks (F-RANs) with the objective to minimize the overall back-haul traffic. The back-haul traffic is incurred in two ways: the VM replication and data transmission to the cloud. When a user connects to a fog node and requests an application service, there is no back-haul bandwidth consumption if the fog node has the application VM. Otherwise, the VM has to be replicated on the fog node, or the request is forwarded to the cloud. They formulate the replica-based VM placement problem by considering the computing and storage of fog nodes, the user service constraint, as well as the edge bandwidth constraint.

**Note: introduction**

-----------------------------------------------------------------------------------
[270] 2016 **An adaptive cloudlet placement method for mobile applications over gps big data.** ✓

Introduces the concept of movable cloudlets and explores the problem of how to cost-effectively deploy these movable cloudlets to enhance cloud services for dynamic context-aware mobile applications. To this end, Haolong Xiang et al. propose an adaptive cloudlet placement (via GPS) method for mobile applications. Specifically, the gathering regions of the mobile devices are identified based on position clustering, and the cloudlet destination locations are confirmed accordingly. Besides, the traces between the origin and destination locations of these mobile cloudlets are also achieved.

**Note: introduction, important?**

-----------------------------------------------------------------------------------
[274] 2017 **Efficient placement of multi-component applications in edge computing systems.** ?

The authors address the problem of multi-component application placement on fog nodes. Each application could be modeled as a graph, where each node is a component of the application, and the edges indicate the communication between them.

-----------------------------------------------------------------------------------
[285] 2018 **Mobility support for fog computing: An sdn approach.** ?

Study of mobility support issue in fog computing for guaranteeing service continuity. Propose a novel SDN enabled architecture that is able to facilitate mobility management in fog computing by decoupling mobility management and data forwarding functions. Design an efficient handover scheme by migrating mobility management and route optimization logic to the SDN controller. By employing link layer information, the SDN controller can pre-compute the optimal path by estimating the performance gain of each path.

-----------------------------------------------------------------------------------
[300] 2017 **Emm: Energy-aware mobility management for mobile edge computing in ultra dense networks.** ?

Develop a novel user-centric energy-aware mobility management (EMM) scheme, in order to optimize the delay, under energy consumption constraint of the user. Based on Lyapunov optimization and multi-armed bandit theories, EMM works in an online fashion. Theoretical analysis explicitly takes radio handover and computation migration cost into consideration and proves a bounded deviation on both the delay performance and energy consumption compared with the oracle solution with exact and complete future system information. The proposed algorithm also effectively handles the scenario in which candidate BSs randomly switch ON/OFF during the offloading process of a task.

-----------------------------------------------------------------------------------
[325] 2017 **Router-based brokering for surrogate discovery in edge computing.** ?

This paper examines the problem of discovering surrogates, which are micro-clouds, fog nodes, or cloudlets, used by client devices to offload computation tasks in a fog computing environment. In order to enable the discovery and selection of available surrogates, the authors propose a brokering mechanism in which available surrogates advertise themselves to the broker. The broker receives client requests and considers a number of attributes such as network information, hardware capabilities, and distance to find the best available surrogate for the client. The proposed mechanism is implemented on off-the-shelf home routers. They look at the problem of surrogate discovery in the context of an urban area, where they are faced with a high mobility of devices and users. Multiple brokers are interconnected using Distributed Hash Tables (DHTs) in order to exchange information. In addition, their approach introduces only a small overhead on the devices (routers) and therefore does not impede their normal function.

----------------------------------------------------------------------------------
[385] 2017 **Myifogsim: A simulator for virtual machine migration in fog computing.** ✓

An extension of iFogSim to support mobility through migration of VMs between cloudlets.

**Note: important**

---------------------------------------------------------------------------------
[388] 2017 **Edgecloudsim: An environment for performance evaluation of edge computing systems.** ?

The authors propose another edge computing simulation environment, EdgeCloudSim, that considers both network and computational resources and covers all aspects of edge computing simulation ,including network and computational modelling. Similar to iFogSim, EdgeCloudSim relies on CloudSim as well. Additionally, EdgeCloudSim provides a modular architecture to provide support for a variety of critical functionality and supports simulating multi-tier scenarios where multiple edge servers are running in coordination with upper layer cloud solutions.

- Possível solução?
- Edge computing simulation;
- Fornece uma arquitetura modelar;
- Suporta simulações de cenários multi-tier onde vários edge servers correm em coordenação com uma layer superior de cloud solutions.

----------------------------------------------------------------------------------

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

**Other papers**

-----------------------------------------------------------------------------------
2016 **Scalable Fog Computing with Service Offloading in Bus Networks.** ✓

In this paper, they **leverage the characteristics of buses** and propose a scalable fog computing paradigm with servicing offloading in bus networks. **The bus fog servers not only provide fog computing services for the mobile users on bus, but also are motivated to accomplish the computation tasks offloaded by roadside cloudlets. By this way, the computing capability of roadside cloudlets is significantly extended. They consider an allocation strategy using genetic algorithm (GA). With this strategy, the roadside cloudlets spend the least cost to offload their computation tasks. Meanwhile, the user experience of mobile users are maintained.**

- Tendo em conta as caracteristicas dos autocarros (precorrem as mesmas rotas, muitas paragens, etc..);
- Propõem bus fog servers que fornecem suporte não só aos utilizadores dentro dele mas também para offload de tasks das cloudlets da rua;
- Extendendo as capacidades das cloudlets;
- Utilizam uma estratégia de alocação utilizando genetic algorithm (GA) para minimizar o custo de offload das cloudlets;
- QoE do utilizador é mantida.

-----------------------------------------------------------------------------------
2017 **Fog Computing for the Internet of Mobile Things: issues and challenges.** ✓

This paper analyse what means provide mobility in Fog computing, the main challanges and three good examples where it is necessary. Also point as future work Proactive vs. reactive service migration, Exploit context information to trigger service migration, Fog federation to enable mobile roaming, Virtualization and migration techniques, Compliance with existing interoperability platforms and Integration with mobile networks towards 5G.

**Note: introductory reference**

-----------------------------------------------------------------------------------
2017 **Fog Vehicular Computing Augmentation of Fog Computing Using Vehicular Cloud Computing.** ?

In accordance with the resource restrictions of fog computing, only a limited number of clients are able to use fog computing simultaneously. To alleviate this problem, they presented FVC as a new concept in which many unused resources of vehicles can be leveraged to augment fog computing resources. They also depicted the cross-layer architecture for FVC and elucidated its constitutive components along with their role in the construction of FVC.

**Note: See again**

-----------------------------------------------------------------------------------
2018 **Dynamic Mobile Cloudlet Clustering for Fog Computing.** ✓

Fog Computing is one of the solutions for offloading the task of a mobile. However the capability of fog server is still limited due to the high deployment cost. In this paper, is proposed a dynamic mobile cloudlet cluster policy (DMCCP) to use cloudlets as a supplement for the fog server for offloading. The main idea is that by monitoring each mobile device resource amount, the DMCCP system clusters the optimal cloudlet to meet the requests of different tasks from the local mobile device.

-----------------------------------------------------------------------------------
[Further research]
-----------------------------------------------------------------------------------
- Movable cloudlets and mobile cloudlets
- Foglets