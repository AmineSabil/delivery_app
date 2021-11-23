import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import algorithm.Color;
import algorithm.Djikstra;
import delivery.model.CheckPoint;
import delivery.model.CheckPointType;
import delivery.model.Intersection;
import delivery.model.Path;
import delivery.model.Request;
import delivery.model.Segment;

public class testDjikstra {

	public static void main(String[] args) {
		Intersection i1 = new Intersection("1", 1.1, 1.2);
		i1.setIndex(0);
		Intersection i2 = new Intersection("2", 2.1, 2.2);
		i2.setIndex(1);
		Segment si12 = new Segment(i1, i2, 10.0, "first");
		i1.addSegment(si12);
		
		Intersection i3 = new Intersection("3", 2.1, 2.2);
		i3.setIndex(2);
		Segment si13 = new Segment(i1, i3, 2.0, "first");
		i1.addSegment(si13);
		
		Intersection i4 = new Intersection("4", 2.1, 2.2);
		i4.setIndex(3);
		Segment si34 = new Segment(i3, i4, 2.0, "first");
		i3.addSegment(si34);
		
		Segment si24 = new Segment(i2, i4, 3.0, "first");
		i2.addSegment(si24);
		
		Intersection i5 = new Intersection("5", 2.1, 2.2);
		i5.setIndex(4);
		Segment si45 = new Segment(i4, i5, 3.0, "first");
		i4.addSegment(si45);
		
		Segment si51 = new Segment(i5, i1, 5.0, "first");
		i5.addSegment(si51);
		
		CheckPoint p1 = new CheckPoint(CheckPointType.DEPOT, i1, LocalTime.now());
		CheckPoint pickup = new CheckPoint(CheckPointType.PICKUP, i3,10);
		CheckPoint delivery = new CheckPoint(CheckPointType.DELIVERY, i5,20);
		Request r1 = new Request(pickup, delivery);
		
		List<Request> listRequest = new ArrayList<Request>();
		listRequest.add(r1);
		
		/*Edge e1 = new Edge(seg, i1, i2);
		Edge e1_3 = new Edge(seg2, i1, i3);
		Edge e2 = new Edge(seg4, i2, i4);
		Edge e3 = new Edge(seg3, i3, i4);
		Edge e4 = new Edge(seg5, i4, i5);
		Edge e5 = new Edge(seg51, i5, i1);
		
		List<Edge> connectedI1 = new ArrayList<Edge>();
		connectedI1.add(e1); connectedI1.add(e1_3);
		
		List<Edge> connectedI2 = new ArrayList<Edge>();
		connectedI2.add(e2);
		
		List<Edge> connectedI3 = new ArrayList<Edge>();
		connectedI3.add(e3);
		
		List<Edge> connectedI4 = new ArrayList<Edge>();
		connectedI4.add(e4);
		
		List<Edge> connectedI5 = new ArrayList<Edge>();
		connectedI4.add(e5);
		*/
		List<Intersection> adjacencyList = new ArrayList<Intersection>();
		adjacencyList.add(i1);
		adjacencyList.add(i2);
		adjacencyList.add(i3);
		adjacencyList.add(i4);
		adjacencyList.add(i5);
		
		List<ArrayList<Path>> listPath = new ArrayList<ArrayList<Path>>();
		listPath = Djikstra.computePaths(adjacencyList, listRequest, p1);
		
		for(int i = 0;i<listPath.size();i++) {
			for(int j = 0;j<listPath.get(i).size();j++) {
				System.out.print("Path() de "+i+" vers "+j+" : ");
				if (listPath.get(i).get(j) != null) {
					System.out.print(" Origin : "+listPath.get(i).get(j).getPath().get(0).getOrigin().getIndex());
					System.out.print(" Destination : "+listPath.get(i).get(j).getDestination().getIndex());
				}
				System.out.println();
				/*for(int k = 0;k<listPath.get(i).get(j).getPath().size();k++) {
					
				}*/
			}
		}
		

	}
	
	/*
	public static void runDjikstraAllRequest(List<CheckPoint> listCheckPoints, Graph g) {
		//For all checkPoints -> launch djikstra
	}
	*/

}
