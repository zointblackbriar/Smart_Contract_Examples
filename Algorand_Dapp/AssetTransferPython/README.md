### PREREQUISITIES

While using pip in an anaconda environment is allowed and fine, issues may arise when using pip and conda together, this was clearly mentioned in the conda docs.

One of the best practices when installing packages in an anaconda environment is to use conda for search and install before using pip.

So instead of directly using pip, try to :

Search for pycryptodome in anaconda packages repo

``` conda search pycryptodome ```

pycryptodome is available in anaconda repo .

The next step is to install pycryptodome :

``` conda install -c anaconda pycryptodome ```

or if you want to use conda-foge channel :

``` conda install -c conda-forge pycryptodome ```

this should get pycryptodome installed into your env

To use a requirements.txt file with conda :

``` conda install --yes --file requirements.txt ```

