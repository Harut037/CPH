package org.example.huffman;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Node implements Comparable<Node>{
    private final int frequency;
    private final Node leftNode;
    private final Node rightNode;

    public Node(Node leftNode, Node rightNode) {
        this.frequency = leftNode.getFrequency() + rightNode.getFrequency();
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Node(int frequency) {
        this.frequency = frequency;
        this.leftNode = getLeftNode();
        this.rightNode = getRightNode();
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(frequency,node.getFrequency());
    }
}
