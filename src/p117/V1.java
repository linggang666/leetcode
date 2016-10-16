package p117;

import java.util.ArrayList;
import java.util.List;

public class V1 {
	
	List<TreeLinkNode> curLevelNodes = new ArrayList<>();
	public void connect(TreeLinkNode root) {
        this.curLevelNodes.clear();
        _connect(root, 0);
    }
	private void _connect(TreeLinkNode root, int level) {
		if(root == null) return;
		
		if(this.curLevelNodes.size()<=level){
			this.curLevelNodes.add(root);
		}else{
			this.curLevelNodes.get(level).next = root;
			this.curLevelNodes.set(level, root);
		}
		
		_connect(root.left, level+1);
		_connect(root.right, level+1);
	}
}
