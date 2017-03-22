var DataSourceTree = function(options) {
	this._data 	= options.data;
	this._delay = options.delay;
}

DataSourceTree.prototype.data = function(options, callback) {
	var self = this;
	var $data = null;

	if(!("name" in options) && !("type" in options)){
		$data = this._data;//the root tree
		callback({ data: $data });
		return;
	}
	else if("type" in options && options.type == "folder") {
		if("additionalParameters" in options && "children" in options.additionalParameters)
			$data = options.additionalParameters.children;
		else $data = {}//no data
	}
	
	if($data != null)//this setTimeout is only for mimicking some random delay
		setTimeout(function(){callback({ data: $data });} , parseInt(Math.random() * 500) + 200);

	//we have used static data here
	//but you can retrieve your data dynamically from a server using ajax call
	//checkout examples/treeview.html and examples/treeview.js for more info
};


// var treeDataSource={};
var createTreeData=function (data){
	var temData=data;
	var child=data.childMenu;
	var childData={};
	var tree_data = {};
	for(var i=0;i<child.length;i++){
		//两级目录
		{
				for(var j=0;j<child.length;j++){
					childData[child[j].name]={
										name:child[j].name,
										type:'item'
								}
					}
			}
		
		{
				tree_data[temData.name]={
						name:temData.name,
						type: 'folder',
						additionalParameters:
						{'children' :childData}
				};
		}
	}

var temple_tree_data = {
		'for-sale' : {name: 'For Sale', type: 'folder', additionalParameters:{'children' : {
			'appliances' : {name: 'Appliances', type: 'item'},
			'arts-crafts' : {name: 'Arts & Crafts', type: 'item'},
			'clothing' : {name: 'Clothing', type: 'item'},
			'computers' : {name: 'Computers', type: 'item'},
			'jewelry' : {name: 'Jewelry', type: 'item'},
			'office-business' : {name: 'Office & Business', type: 'item'},
			'sports-fitness' : {name: 'Sports & Fitness', type: 'item'}
		}}}	,
		'vehicles' : {name: 'Vehicles', type: 'folder'}	,
		'rentals' : {name: 'Rentals', type: 'folder'}	,
		'real-estate' : {name: 'Real Estate', type: 'folder'}	,
		'pets' : {name: 'Pets', type: 'folder'}	,
		'tickets' : {name: 'Tickets', type: 'item'}	,
		'services' : {name: 'Services', type: 'item'}	,
		'personals' : {name: 'Personals', type: 'item'}
	}

console.log(temple_tree_data);

	return new DataSourceTree({data: temple_tree_data});
};


//var treeDataSource = new DataSourceTree({data: tree_data});


