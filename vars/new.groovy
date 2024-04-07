import com.wm.utils.newClass 

def buildUtils

def call(String name){
    buildUtils = new newClass()
    buildUtils.MyFunctions.greet(name)

    def request = libraryResource 'example/test/sample.txt'
    echo "$request"
}


