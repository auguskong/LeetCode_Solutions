/*
copy the code from the youtube mycodeschool
*/

#include<iostream>
using namespace std;
struct Node
{
	int data;
	struct Node *left;
	struct Node *right;
};

struct Node* Delete(struct Node, *root, int data) {
	if (root == NULL) return root;
	else if (data < root->data) root->left = Delete(root->left, data);
	else if (data > root->data) root->right = Delete(root->right, data);
	else {
		//case1: no child
		if (root->left == NULL && root->right == NULL) {
			delete root;
			root = NULL;
		}

		else if (root->left == NULL) {
			struct Node *temp = root;
			root = root->right;
			delete temp;
		}

		else if (root->left == NULL) {
			struct Node *temp = root;
			root = root->left;
			delete temp;
		}

		else {
			struct Node *temp = FindMin(root->right);
			root->data = temp->data;
			root->right = Delete(root->right, temp->data);
		}
	}
	return root;
}