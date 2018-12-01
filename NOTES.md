Fields
----------
| Field 									| Report 	| Implemented 	| Notes 														|
| --- 										| :---: 	| :---: 		| :---: 														|
| QoS 										| ✓ 		| ✓ 			| - 															|
| Bandwidth 								| ✓ 		| ✓ 			| - 															|
| Energy 									| ✓ 		| ✓ 			| - 															|
| Cost 										| ✓ 		| ✓ 			| - 															|
| Handover 									| ✓ 		| ✗ 			| - 															|
| Load Balancing 							| ✓ 		| ✗ 			| Not explicitly but, the algorithm should achieve this feature |
| Vehicular Fog Computing 					| ✓ 		| ✗ 			| Just to provide case studies 									|
| Predicted Mobility Patterns 				| ? 		| ? 			| - 															|
| Proactive vs. Reactive Service Migration 	| ? 		| ? 			| - 															|
| Data placement 							| ✓ 		| ✗ 			| - 															|
| VM/Resource/Job scheduling 				| ✗ 		| - 			| - 															|
| Virtual Objects 							| ✓ 		| ✓ 			| - 															|
| Foglets 									| ✓ 		| ✓ 			| - 															|
| Toolkits 									| ✓ 		| ✓ 			| - 															|
| Data/Session Consistency 					| ✗ 		| - 			| - 															|
| VM/Resource/Job scheduling 				| ✗ 		| - 			| - 															|

Notes
----------
- Publication papers:
	- IEEE InfoCom
	- IEEE GLOBECOM
	- IFIP Networking
- Key-works:
	- Ease
	- Continuum
	- Furthermore,
	- Observe that
	- In a nutshell,
	- As we shall show,
	- Meanwhile, in order
	- As a matter of fact,
	- At first sight it seems
	- Aforementioned benefits
	- The main reasons lie on Fig. xx
	- It is also worth emphasizing that
	- While the former ... , the latter ...
	- have been considered as means to provide
	- The trend towards edge-clouds is expected
	- We tackle the edge cloud network design problem
	- Which is, to the best of our knowledge, an untreated problem in the literature
- TODO:
	- Organize BibteX
	- Monetary cost model
	- Single vs Multi-Objective
	- iFogsim w/ data placement
	- Paper recap and CloudReports
	- Remove toolkit that is not available
	- Check where bus papers was performed
	- List with all variables of our algorithm
	- Miss multi-tier application model parameter in the toolkit table
	- Load Balancing - Not explicitly but, the algorithm should achieve this feature
	- Write about both iFogsim and MyiFogSim characteristics and features to be implemented
	- First fit heuristic, a genetic algorithm, and an exact optimization method (Architecture)
	- Check computing paradigms table and compare with the text (attention with the mist computing)
	- When comparing the toolkits (architecture) refer that iFogSim shadows network problems allowing to choose a delay
- Final TODO:
	- Acronym table
	- Names with dots (e.g., L. Ye)
	- Sections with capital letters
	- Check again objectives in the introduction
- Doubts:
	- Distributed vs centralized fog computing
	- Online (heuristic) vs offline algorithms
	- Proactive vs reactive migration (survey)
	- VM vs containers (survey)
	- Bayesian optimization?
	- grid/power grid?
- Not used papers:
	- Energy-aware user-centric:
		- EMM: Energy-Aware Mobility Management for Mobile Edge Computing in Ultra Dense Networks (described above)
		- Offloading in mobile edge computing: Task allocation and computational frequency scaling
		- Adaptive Computation Scaling and Task Offloading in Mobile Edge Computing (described above)
		- Energy Efficient Optimization for Computation Offloading in Fog Computing System (described above)
	- Replicas:
		- Optimal Placement of Virtual Machines in Mobile Edge Computing
		- A Decentralized Replica Placement Algorithm for Edge Computing
		- Availability-aware Mobile Edge Application Placement in 5G Networks
		- Virtual Machine Placement for Backhaul Traffic Minimization in Fog Radio Access Networks (described above)
	- Handoff:
		- Towards Virtual Machine Migration in Fog Computing
		- Adaptive VM Handoff Across Cloudlets (not applied to fog)
		- You Can Teach Elephants to Dance: Agile VM Handoff for Edge Computing
		- Live Virtual Machine Migration with Adaptive Memory Compression (not applied to fog)
		- Cost of Virtual Machine Live Migration in Clouds: A Performance Evaluation (not applied to fog)
		- Avaptive avatar handoff in the cloudlet network
		- Mobility support for fog computing: An sdn approach (described above)
		- Efficient service handoff across edge servers via docker container migration (described above)
		- Optimizing service Fb for mobile delay-sensitive applications in 5g edge network (described above)
		- Follow me fog: Toward seamless handover timing schemes in a fog computing environment (described above)
		- https://opensource.com/resources/what-docker
		- Incremental deployment and migration of geo-distributed situation awareness applications in the fog
	- Pricing:
		- Paying Less for More? Combo Plans for Edge-Computing Services
		- Fog Computing Micro Datacenter Based Dynamic Resource Estimation and Pricing Model for IoT (resource estimation)
		- Particle swarm optimization for bi-level pricing problems in supply chains - pricing problems with the buyer and the vendor (not applied to fog)
	- Framework:
		- OpenStack extensions for QoS and energy efficiency in edge computing
		- SpanEdge: Towards Unifying Stream Processing over Central and Near-the-Edge Data Centers (does not take into account mobility)
		- Multitier Fog Computing With Large-Scale IoT Data Analytics for Smart Cities (first efforts on mobile fog nodes, described above)
	- Data placement;
		- When Clones Flock Near the Fog (described above)
		- Fast Transparent Virtual Machine Migration in Distributed Edge Clouds (network transparency)
		- Move with Me: Scalably Keeping Virtual Objects Close to Users on the Move (QoS, VOs, described above)
		- Virtual Fog: A Virtualization Enabled Fog Computing Framework for Internet of Things (described above)
		- Supporting Internet-of-Things Analytics in a Fog Computing Platform (maximize number of satisfied users, does not consider migration)
		- Computing Resource Allocation in Three-Tier IoT Fog Networks: A Joint Optimization Approach Combining Stackelberg Game and Matching (described above)
	- Vehicular fog computing:
		- Foud: Integrating Fog and Cloud for 5G-Enabled V2G Networks
		- Vehicular Fog Computing: A Viewpoint of Vehicles as the Infrastructures
		- Vehicular Micro Clouds as Virtual Edge Servers for Efficient Data Collection
		- Fog Vehicular Computing Augmentation of Fog Computing Using Vehicular Cloud Computing
		- Toward Efficient Content Delivery for Automated Driving Services: An Edge Computing Solution
		- Cooperative Fog Computing for Dealing with Big Data in the Internet of Vehicles: Architecture and Hierarchical Resource Management
	- To implement:
		- Mobile edge cloud network design optimization (2017-37)
		- On Reducing IoT Service Delay via Fog Offloading (delay)(2018-13)
		- Fast and Efficient Network Service Embedding Method with Adaptive Offloading to the Edge (cost-aware Virtual Network Function migration)(2018-1)
		- A Game-Theoretic Approach to Coalition Formation in Fog Provider Federations(Profit-aware, QoS)(2018-3)
		- Multiobjective Optimization for Computation Offloading in Fog Computing (energy, cost, QoS)(2018-21)
		- Asymptotically Optimal Algorithm for Online Reconfiguration of Edge-Clouds (cost-QoS??)(2016-21)
		- MOERA: Mobility-agnostic Online Resource Allocation for Edge Computing (cost)(2018-0)
		- Toward Hierarchical Mobile Edge Computing: An Auction-Based Profit Maximization Approach (profit vs QoS)(2017-22)
		- Towards QoS-aware Fog Service Placement (just QoS, fog colonies)
		- A PSO Model with VM Migration and Transmission Power Control for Low Service Delay in the Multiple Cloudlets ECC Scenari (QoS)
		- Traffic-Aware Virtual Machine Placement in Cloudlet Mesh with Adaptive Bandwidth (bandwidth-aware data placement)

----------
**Energy Efficient Optimization for Computation Offloading in Fog Computing System**

Z Chang et al. investigate the energy efficient computation offloading scheme in a multi-user fog computing system. Because offloading the requests/tasks to the cloud/fog can save the energy at the mobile devices, but an unavoidable delay incurs, based on their energy consumption and delay constraint, users need to make the decision on whether to offload the tasks to the fog node nearby. Using queuing theory, they bring a thorough study on the energy consumption and execution delay of the offloading process. Two queuing models are applied respectively to model the execution processes at the mobile device and at the fog node. Based on the theoretical analysis, they present an energy consumption optimization problem with explicit consideration of delay performance. A energy efficient optimization problem is formulated, which involves minimizing the energy consumption by finding the optimal offloading probability and transmit power, subjects to the delay and power constraints. They propose an Alternating Direction Method of Multipliers (ADMM)-based to address the formulated problem in a distributed manner.

**MyiFogSim: A Simulator for Virtual MachineMigration in Fog Computing**

MM Lopes et al. discuss resource allocation in fog computing in the face of users’ mobility, where mobility is achieved through migration of virtual machines between cloudlets. They present a new migration technique composed of two modules: migration policy which defines when the user VM should be migrated, considering aspects such as the user's speed, direction and geographical position and migration strategy, the destination cloudlet, and how the migration is performed. This work had the objective of study the impact of different migration strategies in the latency with users’ mobility.

**Adaptive Computation Scaling and Task Offloading in Mobile Edge Computing**

TQ Dinh et al. propose an optimization framework of offloading from a single mobile device (MD) to multiple edge devices. The objective of this work is to minimize both total tasks’ execution latency and the mobile device’s energy consumption by jointly optimizing the task allocation decision and the mobile device’s central process unit (CPU) frequency by using Dynamic Voltage Frequency Scalling (DVFS). They consider two case studies: fixed CPU frequency and elastic CPU frequency. The formulation of these problems are NP-hard, so they propose a linear relaxation-based approach and a semidefinite relaxation (SDR)-based approach for the fixed CPU frequency case, and an exhaustive searchbased approach and an SDR-based approach for the elastic CPU frequency case.

**Multitier Fog Computing With Large-Scale IoT Data Analytics for Smart Cities**

In this paper a multi tier fog computing model with large-scale data analytics service is proposed for smart cities applications. It is consisted of ad-hoc fogs and dedicated fogs with opportunistic and dedicated computing resources, respectively. They run analytics benchmark experiments over fogs formed by Raspberry Pis with a distributed computing engine to measure computing performance. QoS aware admission control, offloading, and resource allocation schemes are designed to support data analytics services, and maximize analytics service utilities. Availability and cost models of networking and computing resources are taken into account in QoS scheme design. A scalable system level simulator is developed to evaluate the fog-based analytics service and the QoS management schemes.

**Computing Resource Allocation in Three-Tier IoT Fog Networks: A Joint Optimization Approach Combining Stackelberg Game and Matching**

This paper considers a specific fog computing network consisting of a set of data service operators (DSOs) each of which controls a set of fog nodes (FNs) to provide the required data service to a set of data service subscribers (DSSs). They address the problem of how to allocate the limited computing resources of FNs to all the DSSs to achieve an optimal and stable performance. Therefore, they propose a joint optimization in a distributed fashion. In the framework, they formulate a Stackelberg game to analyze the pricing problem for the DSOs as well as the resource allocation problem for the DSSs.

**Virtual Machine Placement for Backhaul Traffic Minimization in Fog Radio Access Networks**

How to appropriately place virtual machines (VMs) into fog nodes in F-RAN systems is very challenging, and will significantly affect the bandwidth consumption of backhaul links. Thus, Ya-Ju Yu et al. analyse the VM placement problem in fog radio access networks (F-RANs) with the objective to minimize the overall back-haul traffic. The back-haul traffic is incurred in two ways: the VM replication and data transmission to the cloud. When a user connects to a fog node and requests an application service, there is no back-haul bandwidth consumption if the fog node has the application VM. Otherwise, the VM has to be replicated on the fog node, or the request is forwarded to the cloud. They formulate the replica-based VM placement problem by considering the computing and storage of fog nodes, the user service constraint, as well as the edge bandwidth constraint.

**Virtual Fog: A Virtualization Enabled Fog Computing Framework for Internet of Things**

They propose a layered Fog framework to better support IoT applications through virtualization. The virtualization is divided into object virtualization  (VOs), network function virtualization and service virtualization. VOs to address the protocol inconsistency (lack of unified networking protocols that leads to exaggerated overhead); Network function virtualization maps standard networking services to VOs, thus, minimize the communication process between consumers and producers by minimizing latency, improving security and scalability; Service virtualization that composes the community and Cloud Applications from various vendors to serve local Fog users with high quality of experience (QoE) but at low cost. At last, Foglets are involved to seamless aggregate multiple independent virtual instances, Fog network infrastructures, and software platforms.

**Move with Me: Scalably Keeping Virtual Objects Close to Users on the Move**

With the state-of-the-art virtualization technologies, services can be implemented in modular software as a graph/chain of portable VOs that can be dynamically migrated around the TELCO infrastructure. It is proposed a VO clustering and migration policy that jointly considers user proximity and inter-VO affinity to scalably support user mobility, while allowing service differentiation among users.

**When Clones Flock Near the Fog**
	
S. Abdelwahab et al. argue that IoT devices communicate a large number of messages with many devices. Thus, devices with low computing and storage capacities will became another source of latency for large-scale distributed applications. Their experiments show that brokering the messages through a one-hop away broker may reduce significantly the end-to-end latency. Therefore, if devices are cloned in a one-hop away cloudlet, their clones can provide message brokering service, allowing both a communication with minimal latency between devices and to offload intensive computation into rich memory and processing nodes that host the clones. Nonetheless, communicating through a one-hop away clone may still experience long end-to-end latency when the broker service relays messages to distant devices. Hence, they propose FogMQ, a self-deploying brokering clones that discover hosting platforms and autonomously migrate between them according to the measured end-to-end latency. This method does not need a central monitoring and control unit. FogMQ servers expose tomography functionalities that enables clones to take migration decisions without complete knowledge about the hosting platform. It allows to stabilize clones deployment and achieve a near minimum latency given an existing infrastructure limits.

**Vehicular Fog Computing: A Viewpoint of Vehicles as the Infrastructures**

Xueshi Hou et al. present the idea of utilizing vehicles as the infrastructures for communication and computation, named vehicular fog computing (VFC), which is an architecture that utilizes a collaborative multitude of end-user clients or near-user edge devices to carry out communication and computation, based on better utilization of individual communication and computational resources of each vehicle. They discussed four types of scenarios of moving and parked vehicles or congested traffic. Also, they point out the advantages against vehicular cloud computing (VCC) and the advantages in scenarios like of emergency operations for natural disaster and terrorist attack.

**Cooperative Fog Computing for Dealing with Big Data in the Internet of Vehicles: Architecture and Hierarchical Resource Management**

This paper introduces the challenges of handling big data in the IoV environments. The authors emphasize on the role of fog servers and describe a regional cooperative fog computing (CFC) architecture to support IoV applications. The proposed CFC-IoV architecture consists of two layers. The fog layer is a federation of geographically distributed fog servers, a coordinator server, and the cloud servers, whereas the edge layer includes the vehicular ad hoc network (VANET), IoT applications, and mobile cellular networks.

**Foud: Integrating Fog and Cloud for 5G-Enabled V2G Networks**

This paper argues that cloud and fog computing using the current mobile networks may not be ideally suited to provide the desired levels of QoS for moving electric vehicles in vehicle-to-grid (V2G) services. They propose a hybrid computing model called "Foud" in which the cloud and fog come together and are made available to the V2G networks in 5G. In the proposed model, the cloud allows virtualized computing, storage, and network resources to be available to the V2G system entities, whereas the fog temporarily integrates the stationary and mobile computing resources located at the edge of V2G networks to expand the computing capacity.

**Vehicular Micro Clouds as Virtual Edge Servers for Efficient Data Collection**

The concept of vehicular micro clouds based on map information is introduced, and, by a simulation study, investigated. Vehicular micro clouds are virtual edge servers and are essentially clusters of cars that help to aggregate and preprocess data that is transferred to the cloud.

**Fog Vehicular Computing Augmentation of Fog Computing Using Vehicular Cloud Computing**

In accordance with the resource restrictions of fog computing, only a limited number of clients are able to use fog computing simultaneously. To alleviate this problem, they presented FVC as a new concept in which many unused resources of vehicles can be leveraged to augment fog computing resources. They also depicted the cross-layer architecture for FVC and elucidated its constitutive components along with their role in the construction of FVC.

**Toward Efficient Content Delivery for Automated Driving Services: An Edge Computing Solution**

They propose a two-level edge computing architecture for automated driving services in order to make full use of the intelligence at the wireless edge (i.e., base stations and autonomous vehicles) for coordinated content delivery. Then they investigate the research challenges of wireless edge caching and vehicular content sharing. Finally, they propose potential solutions to these challenges and evaluate them using real and synthetic traces.

**Follow me fog: Toward seamless handover timing schemes in a fog computing environment**

The authors observe that traditional mobile network handover mechanisms cannot handle the demands of fog computation resources and the low-latency requirements of mobile IoT applications. The authors propose Follow Me Fog framework to guarantee service continuity and reduce latency during handovers. The key idea proposed is to continuously monitor the received signal strength of the fog nodes at the mobile IoT device, and to trigger pre-migration of computation jobs before disconnecting the IoT device from the existing fog node.

**Efficient service handoff across edge servers via docker container migration**

Present a novel service handoff system which seamlessly migrates offloading services to the nearest edge server, while the mobile client is moving. Service handoff is achieved via container migration. They have identified an important performance problem during Docker container migration, proposing a migration method which leverages the layered storage system to reduce file system synchronization overhead, without dependence on the distributed file system.

**Emm: Energy-aware mobility management for mobile edge computing in ultra dense networks**

Develop a novel user-centric energy-aware mobility management (EMM) scheme, in order to optimize the delay, under energy consumption constraint of the user. Based on Lyapunov optimization and multi-armed bandit theories, EMM works in an online fashion. Theoretical analysis explicitly takes radio handover and computation migration cost into consideration and proves a bounded deviation on both the delay performance and energy consumption compared with the oracle solution with exact and complete future system information. The proposed algorithm also effectively handles the scenario in which candidate BSs randomly switch ON/OFF during the offloading process of a task.

**Mobility support for fog computing: An sdn approach**

Study of mobility support issue in fog computing for guaranteeing service continuity. Propose a novel SDN enabled architecture that is able to facilitate mobility management in fog computing by decoupling mobility management and data forwarding functions. Design an efficient handover scheme by migrating mobility management and route optimization logic to the SDN controller. By employing link layer information, the SDN controller can pre-compute the optimal path by estimating the performance gain of each path.

**Optimizing service Fb for mobile delay-sensitive applications in 5g edge network**

To guarantee the strict latency requirements, new solutions are required to cope with the user mobility in a distributed edge cloud environment. The use of proactive replication mechanism seems promising to avoid QoE degradation during service migration between different edge nodes. However, accounting for the limited resources of edge micro data-centers, appropriate optimization solutions must be developed to reduce the cost of service deployment, while guaranteeing the desired QoE. In this paper, Ivan Farris et al., by leveraging on prediction schemes of user mobility patterns, have proposed two linear optimization solutions for replication-based service migration in cellular 5G networks: the min-RM approach aims at minimizing the QoE degradation during user handover; min-NSR approach favors the reduction of service replication cost. Simulation results proved the efficiency of each solution in achieving its design goal and provides useful information for network and service orchestrators in next-generation 5G cloud-based networks.