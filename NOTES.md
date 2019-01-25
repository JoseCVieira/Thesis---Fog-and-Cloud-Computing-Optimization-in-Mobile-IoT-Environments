Fields
----------
| Field 									| Report 	| Implemented 	| Notes 																|
| --- 										| :---: 	| :---: 		| :---: 																|
| QoS 										| ✓ 		| ✓ 			| - 																	|
| Bandwidth 								| ✓ 		| ✓ 			| - 																	|
| Energy 									| ✓ 		| ✓ 			| - 																	|
| Cost 										| ✓ 		| ✓ 			| - 																	|
| Load Balancing 							| ✓ 		| ✗ 			| Not explicitly but, the algorithm should achieve this feature 		|
| Vehicular Fog Computing 					| ✓ 		| ✗ 			| Just to provide case studies 											|
| Service Migration 						| ✓ 		| ✓ 			| Proactive vs. reactive, VM vs container, live vs non-live migration	|
| (Des)Centralized Service Migration 		| ✓ 		| ✓ 			| -																		|
| Foglets 									| ✓ 		| ✓ 			| - 																	|
| Toolkits 									| ✓ 		| ✓ 			| - 																	|
| Data placement 							| ✗ 		| - 			| - 																	|
| Data/Session Consistency 					| ✗ 		| - 			| - 																	|
| VM/Resource/Job scheduling 				| ✗ 		| - 			| - 																	|
| Predicted Mobility Patterns 				| ✗ 		| - 			| - 																	|
| Virtual Objects 							| ✗ 		| - 			| - 																	|
| Handover 									| ✗ 		| - 			| - 																	|

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
	- For the sake of tractability we only consider
	- We tackle the edge cloud network design problem 
	- Which is, to the best of our knowledge, an untreated problem in the literature
	- (refer to Fig. 1)
- TODO:
	- Miss multi-tier application model parameter in the toolkit table
- Doubts:
	- Online (heuristic) vs offline algorithms
	- Bayesian optimization?
	- Greedy one-shot vs greedy first fit?

- Not used papers:
	- Introduction:
		- Google’s self-driving car gathers nearly 1GB/sec
		- Is Fog Computing The Next Big Thing In Internet of Things?
		- Fog Computing for the Internet of Mobile Things: Issues and Challenges (some use cases)
	- Energy-aware user-centric:
		- EMM: Energy-Aware Mobility Management for Mobile Edge Computing in Ultra Dense Networks (described bellow)
		- Offloading in mobile edge computing: Task allocation and computational frequency scaling
		- Adaptive Computation Scaling and Task Offloading in Mobile Edge Computing (described bellow)
		- Energy Efficient Optimization for Computation Offloading in Fog Computing System (described bellow)
	- Replicas:
		- Optimal Placement of Virtual Machines in Mobile Edge Computing
		- A Decentralized Replica Placement Algorithm for Edge Computing
		- Adaptive Avatar Handoff in the Cloudlet Network (described bellow)
		- Availability-aware Mobile Edge Application Placement in 5G Networks
		- Virtual Machine Placement for Backhaul Traffic Minimization in Fog Radio Access Networks (described bellow)
		- Optimizing Service Replication for Mobile Delay-sensitive Applications in 5G Edge Network (described bellow)
	- Handoff:
		- https://opensource.com/resources/what-docker
		- Towards Virtual Machine Migration in Fog Computing
		- Adaptive VM Handoff Across Cloudlets (not applied to fog)
		- You Can Teach Elephants to Dance: Agile VM Handoff for Edge Computing
		- Mobility Support for Fog Computing: An SDN Approach (described bellow)
		- Live Virtual Machine Migration with Adaptive Memory Compression (not applied to fog)
		- Cost of Virtual Machine Live Migration in Clouds: A Performance Evaluation (not applied to fog)
		- Follow Me Fog: Toward Seamless Handover Timing Schemes in a Fog Computing Environment (described bellow)
	- Pricing:
		- Paying Less for More? Combo Plans for Edge-Computing Services
		- Toward Hierarchical Mobile Edge Computing: An Auction-Based Profit Maximization Approach (TO IMPLEMNET.. MAYBE)
		- Fog Computing Micro Datacenter Based Dynamic Resource Estimation and Pricing Model for IoT (resource estimation)
		- Particle swarm optimization for bi-level pricing problems in supply chains - pricing problems with the buyer and the vendor (not applied to fog)
	- Framework:
		- OpenStack extensions for QoS and energy efficiency in edge computing
		- SpanEdge: Towards Unifying Stream Processing over Central and Near-the-Edge Data Centers (does not take into account mobility)
		- Multitier Fog Computing With Large-Scale IoT Data Analytics for Smart Cities (first efforts on mobile fog nodes, described bellow)
	- Data placement;
		- When Clones Flock Near the Fog (described bellow)
		- Dynamic Mobile Cloudlet Clustering for Fog Computing
		- Towards QoS-aware Fog Service Placement (just QoS, fog colonies)
		- On Reducing IoT Service Delay via Fog Offloading (delay, data placement)
		- Online Placement of Multi-Component Applications in Edge Computing Environments
		- Asymptotically Optimal Algorithm for Online Reconfiguration of Edge-Clouds (cost-QoS)
		- Fast Transparent Virtual Machine Migration in Distributed Edge Clouds (network transparency)
		- A Game-Theoretic Approach to Coalition Formation in Fog Provider Federations (Profit-aware, QoS)
		- Move with Me: Scalably Keeping Virtual Objects Close to Users on the Move (QoS, VOs, described bellow)
		- Virtual Fog: A Virtualization Enabled Fog Computing Framework for Internet of Things (described bellow)
		- Supporting Internet-of-Things Analytics in a Fog Computing Platform (maximize number of satisfied users, does not consider migration)
		- Traffic-Aware Virtual Machine Placement in Cloudlet Mesh with Adaptive Bandwidth (bandwidth-aware data placement, does not consider mobility)
		- Computing Resource Allocation in Three-Tier IoT Fog Networks: A Joint Optimization Approach Combining Stackelberg Game and Matching (described bellow)
	- Vehicular fog computing:
		- Foud: Integrating Fog and Cloud for 5G-Enabled V2G Networks
		- Vehicular Fog Computing: A Viewpoint of Vehicles as the Infrastructures
		- Vehicular Micro Clouds as Virtual Edge Servers for Efficient Data Collection
		- Fog Vehicular Computing Augmentation of Fog Computing Using Vehicular Cloud Computing
		- Toward Efficient Content Delivery for Automated Driving Services: An Edge Computing Solution
		- Cooperative Fog Computing for Dealing with Big Data in the Internet of Vehicles: Architecture and Hierarchical Resource Management
	- Last Removed papers
		- Dynamic service migration and workload scheduling in edge-clouds
		- Towards efficient edge cloud augmentation for virtual reality MMOGs
		- Profit-aware Resource Management for Edge Computing Systems
		- Resource Constrained Offloading in Fog Computing

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

**Follow Me Fog: Toward Seamless Handover Timing Schemes in a Fog Computing Environment**

The authors observe that traditional mobile network handover mechanisms cannot handle the demands of fog computation resources and the low-latency requirements of mobile IoT applications. The authors propose Follow Me Fog framework to guarantee service continuity and reduce latency during handovers. The key idea proposed is to continuously monitor the received signal strength of the fog nodes at the mobile IoT device, and to trigger pre-migration of computation jobs before disconnecting the IoT device from the existing fog node.

**Efficient Service Handoff Across Edge Servers via Docker Container Migration**

Present a novel service handoff system which seamlessly migrates offloading services to the nearest edge server, while the mobile client is moving. Service handoff is achieved via container migration. They have identified an important performance problem during Docker container migration, proposing a migration method which leverages the layered storage system to reduce file system synchronization overhead, without dependence on the distributed file system.

**Emm: Energy-aware mobility management for mobile edge computing in ultra dense networks**

Develop a novel user-centric energy-aware mobility management (EMM) scheme, in order to optimize the delay, under energy consumption constraint of the user. Based on Lyapunov optimization and multi-armed bandit theories, EMM works in an online fashion. Theoretical analysis explicitly takes radio handover and computation migration cost into consideration and proves a bounded deviation on both the delay performance and energy consumption compared with the oracle solution with exact and complete future system information. The proposed algorithm also effectively handles the scenario in which candidate BSs randomly switch ON/OFF during the offloading process of a task.

**Mobility Support for Fog Computing: An SDN Approach**

Study of mobility support issue in fog computing for guaranteeing service continuity. Propose a novel SDN enabled architecture that is able to facilitate mobility management in fog computing by decoupling mobility management and data forwarding functions. Design an efficient handover scheme by migrating mobility management and route optimization logic to the SDN controller. By employing link layer information, the SDN controller can pre-compute the optimal path by estimating the performance gain of each path.

**Optimizing Service Replication for Mobile Delay-sensitive Applications in 5G Edge Network**

To guarantee the strict latency requirements, new solutions are required to cope with the user mobility in a distributed edge cloud environment. The use of proactive replication mechanism seems promising to avoid QoE degradation during service migration between different edge nodes. However, accounting for the limited resources of edge micro data-centers, appropriate optimization solutions must be developed to reduce the cost of service deployment, while guaranteeing the desired QoE. In this paper, Ivan Farris et al., by leveraging on prediction schemes of user mobility patterns, have proposed two linear optimization solutions for replication-based service migration in cellular 5G networks: the min-RM approach aims at minimizing the QoE degradation during user handover; min-NSR approach favors the reduction of service replication cost. Simulation results proved the efficiency of each solution in achieving its design goal and provides useful information for network and service orchestrators in next-generation 5G cloud-based networks.

**Adaptive Avatar Handoff in the Cloudlet Network**

X. Sun et al. shows an architecture where each User Equipment (UE) has its own Avatar (a private computing and storage resources for the UE) which is deployed to a cloudlet, being the communication characterized by low end-to-end (E2E) latency. When UEs roam away, in order to maintain the end-to-end latency, their Avatars should be handed off among cloudlets accordingly. However, moving such amount of data (the Avatar’s virtual disk) during the handoff time may both incur unbearable migration time and network congestion. In order to overcome those limitations, they propose LatEncy Aware Replica placemeNt (LEARN) algorithm to place a number of replicas of each Avatar’s virtual disk into suitable cloudlets. Meanwhile, by considering the capacity limitation of each cloudlet, they propose the LatEncy aware Avatar hanDoff (LEAD) algorithm to place UEs’ Avatars among the cloudlets such that the average E2E delay is minimized.

**Mist Computing**

Mist computing pushes processing even further to the network edge, involving the sensor and actuator devices. This decreases latency and increases subsystems’ autonomy. In such scenarios, self-awareness of every device is critical as the computation and actuation are dependent on the device’s perception of the situation. The challenge with implementing mist computing systems lies in the complexity and interactions of the resulting network, which must be managed by the devices themselves as central management of such systems is not feasible.

State Collection Module gathers and stores real time network states, edge cloud workloads, and client mobility patterns. Then SEGUE estimates the expected response time for any user moving around a geographical region with access to an edge cloud under dynamic network states and varying edge cloud workloads. This prediction is performed by the QoS Prediction Module which recomputes it whenever there are a user moves, or there are changes in server or network workloads. This module answers the WHEN to migrate. The Edge Cloud Selection Module uses outputs provided by the State Collection Module and the QoS Prediction Module to solve the problem of finding an optimal edge cloud to migrate to. Thus it answers the WHERE to migrate by using MDP. They assume whenever a user needs to connect to a fog node, it is connected to the one with minimal hop count. The Service Migration Module is, responsible to preparate the application environment and initialize the application VM. To realize network and server states they use server push and client proxy probe. The server push is responsible for constantly monitoring and reporting response time whenever there is a response time shift that exceeds a predefined threshold (it clusters response time from anywhere in the network thus it reflects the server state but cannot distinguish the network link state). The client proxy periodically sends probing requests to all potential fog nodes, reflecting the network state between them (this generates big overhead). To predict QoS based on the user mobility, we integrate the linearity of expectation into the Autoregressive Integrated Moving Average(ARIMA) forecaster. We then weight the QoS prediction by a factor of mobility uncertainty. The QoS prediction module assumes that mobile location, follows the one dimensional mobility pattern (in t+1 the user can move back (n-1), n+1 or stay at n). The problem formulation is then formulated as a cost-reward between the predicted long term QoS improvement and the service downtime.

----------
**Alternating Direction Method of Multipliers ADMM**
- Same principal of penalty methods
- Introduce another term into the cost function (Lagrange multiplier)
- Uses partial updates in Gauss-Seidel method
- Gauss-Seidel method:
	- Similar to Jacobi method to solve linear equations
	- Converge assuredly for quadratic matrices with dominant diagonal
	- Or with symmetric and positive definite

**Mixed-Integer Linear Programming**
- Linear programming maximizes (or minimizes) a linear objective function subject to one or more constraints (linear equalities/inequalities)
- Mixed integer programming adds one additional condition that at least one of the variables can only take on integer values
- Its feasible region is a convex polytopes, which is a set defined as the intersection of finitely many half spaces, each of which is defined by a linear inequality.

**Mixed-Integer Quadratic Programming**
- Quadratic programming (QP) is the process of solving a (linearly constrained) quadratic optimization problem
- The problem of optimizing a quadratic function of several variables subject to linear constraints on these variables
- Quadratic programming is a particular type of nonlinear programming

**Interior Point Method**
- Barrier methods (similar to the penalty method but the barrier is in place to bias the iterates to remain away from the boundary of the feasible region)
- Class of algorithms that solve linear and nonlinear convex optimization problems

**Minimum Graph Cuts**
- Cut (a partition of the vertices of a graph into two disjoint subsets; that are joined by at least one edge) that is minimal in some sense.

**Lyapunov optimization**
- Lyapunov optimization refers to the use of a Lyapunov function to optimally control a dynamical system
- Ensures different forms of system stability


----------
Melhorar a
abreviações cannot etc..
where is,
apresentar um exemplo na introdução
objetivos não muito claros (optimização na literatura é relevante mas falta a parte de mobilidade, por exemplo)
comparar o tempo de execução
procurar um ambiente de mais baio nivel omnet++
mobility support tem de mais especifico(vm mig. e mobilidade dos users)
myifog sim - is not perfect at all -> apontar para uma tabela comparativa de trabalhos relacionados