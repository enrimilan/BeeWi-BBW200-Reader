using System.Threading.Tasks;

namespace Reader.Reader
{
    interface ISensorReader
    {
        Task<string[]> ReadRawData();
    }
}
