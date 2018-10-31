-----
**1st meeting - 04/10/2018**

- Thesis objectives
	- Provide mobility support to fog nodes (e.g., in MyiFogSim)
	- Implement an optimization algorithm based on latency (e.g., Genetic Algorithm)
	- Multi-objective optimization (e.g., QoS, QoE, Cost, Energy, Bandwidth)
	
- TODO
	- Test both iFogSim and MyiFogSim simulators
		- iFogSim: https://github.com/Cloudslab/iFogSim
		- MyiFogSim: https://github.com/marciocomp/myifogsim
	
	- Report introduction
		- Context: Cloud, Fog, Edge...
		- Motivation: Application examples (e.g., bus with computational resources)
		- Work objectives

	- Related work

-----

**2nd meeting - 18/10/2018**

- Thesis objectives
	- Mobility support
		- Handover
		- Load balancing / resource allocation / data placement (not explicitly but, the algorithm should achieve this feature)
		- Virtual objects / foglets (both all in one VM and application decomposition in modules; for instance, modules with different E2E restrictions)
	- Implement an optimization algorithm based on latency
		- Migration delay
		- Communication delay
		- Processing delay
	- Multi-objective optimization
		- Genetic Algorithm
		- MDP-based algorithm (e.g., SEGUE)
		- If possible, compare them

- TODO
	- Check both iFogSim and MyiFogSim architectures
		- Try to understand where the mobility of servers can be implemented
	- As MyiFogSim does not work (an exception is thrown and the program ends)
		- Take into account the possibility of using EdgeCloudSim as a surrogate
		- https://github.com/CagataySonmez/EdgeCloudSim
	- Check if all the parameters of the MDP-based algorithm are taken into account in iFogSim or in MyiFogSim
		- https://ieeexplore.ieee.org/abstract/document/7830702
	- Keep working on the report

-----