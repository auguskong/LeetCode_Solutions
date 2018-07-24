struct Node* Getsuccessor(struct Node* root, int data) {
	//Search the Node
	struct Node* current = Find(root, data); //O(h) 时间复杂度
	if (current == NULL) return NULL;
	//CASE1: Node has right subtree
	if (current -> right != NULL) {
		return FindMin(current -> right);
	}
	//Case2: No right subtree
	else {
		struct Node* successor = NULL;
		struct Node* ancestor = root;
		while (ancestor != current) {
			//successor 一定是要比current 数值大的，所以只在 if 中进行更新
			if (current -> data < ancestor -> data) {
				successor = ancestor;
				ancestor = ancestor -> left;
			}
			else {
				ancestor = ancestor -> right;
			}

			return successor;
		}
	}
}

struct Node* Find(struct Node* root, int data) {
	if (root == null) {
		return null;
	}
	while (root.val != data) {
		if (root.val < data) {
			root = root.left;
		}
		else if (root.val > data) {
			root = root.right;
		}
		return root;
	}
}