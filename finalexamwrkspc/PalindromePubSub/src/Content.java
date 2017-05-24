package dw;

import java.util.ArrayList;
public class Content {
public Publisher source_;
public ArrayList<String> data_;
@SuppressWarnings("unchecked")
public Content(Publisher src, ArrayList<String> dat) {
source_ = src;
data_ = (ArrayList<String>) dat.clone(); // for write safety...
} // ...avoid aliasing and create a new copy
}
