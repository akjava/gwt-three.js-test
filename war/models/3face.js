var model = {

    'version' : 2,
    "scale" : 1.000000,
    'materials': [],
    
    "morphTargets": [],

    "morphColors": [],

    "normals": [],

    "colors": [],

    "uvs": [[]],
    
    'vertices': [ 0,0,0, 0,0,1, 1,0,1, 1,0,0,
                  0,1,0,0,1,1,
                  1,1,1],
    'faces': [1,0,1,2,3, 
              1,0,4,5,1,
              1,1,2,6,5]
    }
postMessage( model );
close();